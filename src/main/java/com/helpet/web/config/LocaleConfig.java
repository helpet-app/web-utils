package com.helpet.web.config;

import com.helpet.web.util.Localizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@AutoConfiguration
public class LocaleConfig {
    @ConditionalOnMissingBean
    @Bean
    public AcceptHeaderLocaleResolver acceptHeaderLocaleResolver() {
        Locale defaultLocale = Locale.ENGLISH;
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        Locale.setDefault(defaultLocale);
        localeResolver.setDefaultLocale(defaultLocale);
        return localeResolver;
    }

    @ConditionalOnMissingBean
    @Bean
    public Localizer localizer(@Autowired MessageSource messageSource) {
        return new Localizer(messageSource);
    }
}
