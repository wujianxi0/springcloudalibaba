package com.academy.gateway.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Component
public class ConfigRoutePredicateFactory extends AbstractRoutePredicateFactory<ConfigRoutePredicateFactory.Config> {

    public ConfigRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(ConfigRoutePredicateFactory.Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                MultiValueMap<String, String> queryParams = serverWebExchange.getRequest().getQueryParams();
                List<String> configValue = queryParams.get("config");

                String[] configNameArr = config.getName();
                for(String name : configValue){
                    for(String configName : configNameArr){
                        if(configName.equals(name)){
                            return true;
                        }
                    }
                }

                return false;
            }
        };
    }

    @Override
    public ShortcutType shortcutType() {
        return ShortcutType.GATHER_LIST;
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name");
    }

    public static class Config{
        private String[] name;

        public String[] getName() {
            return name;
        }

        public void setName(String[] name) {
            this.name = name;
        }
    }
}
