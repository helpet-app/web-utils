package com.helpet.web.handler;

import com.helpet.exception.*;
import com.helpet.web.response.ErrorBody;
import com.helpet.web.response.UnsuccessfulResponseBody;
import com.helpet.web.util.Localizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

public class LocalizedExceptionHandler {
    protected Localizer localizer;

    protected LocalizedExceptionHandler(Localizer localizer) {
        this.localizer = localizer;
    }

    protected ResponseEntity<UnsuccessfulResponseBody> buildResponseEntity(LocalizedException ex,
                                                                           HttpStatus status,
                                                                           Locale locale) {
        ErrorBody errorBody = new ErrorBody(ex.getCode(),
                                            localizer.l10n(ex.getExceptionKey(), locale),
                                            localizer.l10n(ex.getReasonKey(), locale));
        return new ResponseEntity<>(new UnsuccessfulResponseBody(errorBody), status);
    }

    @ExceptionHandler(BadRequestLocalizedException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleBadRequestLocalizedException(BadRequestLocalizedException ex,
                                                                                          Locale locale) {
        return buildResponseEntity(ex, HttpStatus.BAD_REQUEST, locale);
    }

    @ExceptionHandler(UnauthorizedLocalizedException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleUnauthorizedLocalizedException(UnauthorizedLocalizedException ex,
                                                                                            Locale locale) {
        return buildResponseEntity(ex, HttpStatus.UNAUTHORIZED, locale);
    }

    @ExceptionHandler(ForbiddenLocalizedException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleForbiddenLocalizedException(ForbiddenLocalizedException ex,
                                                                                         Locale locale) {
        return buildResponseEntity(ex, HttpStatus.FORBIDDEN, locale);
    }

    @ExceptionHandler(NotFoundLocalizedException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleNotFoundLocalizedException(NotFoundLocalizedException ex,
                                                                                        Locale locale) {
        return buildResponseEntity(ex, HttpStatus.NOT_FOUND, locale);
    }

    @ExceptionHandler(ConflictLocalizedException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleConflictLocalizedException(ConflictLocalizedException ex,
                                                                                        Locale locale) {
        return buildResponseEntity(ex, HttpStatus.CONFLICT, locale);
    }
}