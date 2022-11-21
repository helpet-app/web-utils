package com.helpet.web.handler;

import com.helpet.exception.*;
import com.helpet.web.response.ErrorBody;
import com.helpet.web.response.UnsuccessfulResponseBody;
import com.helpet.web.util.Localizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

public class LocalizedResponseEntityExceptionHandler extends BaseResponseEntityExceptionHandler {
    protected Localizer localizer;

    protected LocalizedResponseEntityExceptionHandler(Localizer localizer) {
        this.localizer = localizer;
    }

    protected ResponseEntity<UnsuccessfulResponseBody> buildResponseEntity(LocalizedDetailedException ex,
                                                         HttpStatus status,
                                                         Locale locale) {
        ErrorBody errorBody = new ErrorBody(ex.getCode(),
                                            localizer.l10n(ex.getExceptionKey(), locale),
                                            localizer.l10n(ex.getReasonKey(), locale));
        return new ResponseEntity<>(new UnsuccessfulResponseBody(errorBody), status);
    }

    @ExceptionHandler(BadRequestLocalizedDetailedException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleBadRequestLocalizedDetailedException(BadRequestLocalizedDetailedException ex,
                                                                                Locale locale) {
        return buildResponseEntity(ex, HttpStatus.BAD_REQUEST, locale);
    }

    @ExceptionHandler(UnauthorizedLocalizedDetailedException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleUnauthorizedLocalizedDetailedException(UnauthorizedLocalizedDetailedException ex,
                                                                                  Locale locale) {
        return buildResponseEntity(ex, HttpStatus.UNAUTHORIZED, locale);
    }

    @ExceptionHandler(ForbiddenLocalizedDetailedException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleForbiddenLocalizedDetailedException(ForbiddenLocalizedDetailedException ex,
                                                                               Locale locale) {
        return buildResponseEntity(ex, HttpStatus.FORBIDDEN, locale);
    }

    @ExceptionHandler(NotFoundLocalizedDetailedException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleNotFoundLocalizedDetailedException(NotFoundLocalizedDetailedException ex,
                                                                              Locale locale) {
        return buildResponseEntity(ex, HttpStatus.NOT_FOUND, locale);
    }

    @ExceptionHandler(ConflictLocalizedDetailedException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleConflictLocalizedDetailedException(ConflictLocalizedDetailedException ex,
                                                                              Locale locale) {
        return buildResponseEntity(ex, HttpStatus.CONFLICT, locale);
    }
}
