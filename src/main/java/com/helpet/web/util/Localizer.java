package com.helpet.web.util;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class Localizer {
    private final MessageSource messageSource;

    public Localizer(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String l10n(String key, Locale locale) {
        return messageSource.getMessage(key, null, locale);
    }

    public String l10n(String key, Object[] args, Locale locale) {
        return messageSource.getMessage(key, args, locale);
    }
}
