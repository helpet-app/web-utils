package com.helpet.web.handler;

import com.helpet.exception.*;
import com.helpet.web.response.ErrorBody;
import com.helpet.web.response.UnsuccessfulResponseBody;
import com.helpet.web.util.Localizer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Locale;

public class LocalizedExceptionHandler {
    protected Localizer localizer;

    protected LocalizedExceptionHandler(Localizer localizer) {
        this.localizer = localizer;
    }

    protected UnsuccessfulResponseBody buildResponse(LocalizedException ex, Locale locale) {
        ErrorBody errorBody = new ErrorBody(ex.getCode(),
                                            localizer.l10n(ex.getExceptionKey(), locale),
                                            localizer.l10n(ex.getReasonKey(), locale));
        return new UnsuccessfulResponseBody(errorBody);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestLocalizedException.class)
    protected UnsuccessfulResponseBody handleBadRequestLocalizedException(BadRequestLocalizedException ex, Locale locale) {
        return buildResponse(ex, locale);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedLocalizedException.class)
    protected UnsuccessfulResponseBody handleUnauthorizedLocalizedException(UnauthorizedLocalizedException ex, Locale locale) {
        return buildResponse(ex, locale);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ForbiddenLocalizedException.class)
    protected UnsuccessfulResponseBody handleForbiddenLocalizedException(ForbiddenLocalizedException ex, Locale locale) {
        return buildResponse(ex, locale);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundLocalizedException.class)
    protected UnsuccessfulResponseBody handleNotFoundLocalizedException(NotFoundLocalizedException ex, Locale locale) {
        return buildResponse(ex, locale);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ConflictLocalizedException.class)
    protected UnsuccessfulResponseBody handleConflictLocalizedException(ConflictLocalizedException ex, Locale locale) {
        return buildResponse(ex, locale);
    }
}
