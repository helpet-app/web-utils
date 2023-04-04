package com.helpet.web.handler;

import com.helpet.exception.*;
import com.helpet.web.response.ErrorBody;
import com.helpet.web.response.UnsuccessfulResponseBody;
import com.helpet.web.util.Localizer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.util.ParsingUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
@AutoConfiguration
public class LocalizedExceptionHandler {
    protected Localizer localizer;

    @Autowired
    protected LocalizedExceptionHandler(Localizer localizer) {
        this.localizer = localizer;
    }

    protected ResponseEntity<UnsuccessfulResponseBody> buildResponseEntity(LocalizedException ex, HttpStatus status, Locale locale) {
        ErrorBody errorBody = ErrorBody.builder()
                                       .code(ex.getCode())
                                       .message(localizer.l10n(ex.getMessageKey(), locale))
                                       .build();

        return new ResponseEntity<>(new UnsuccessfulResponseBody(errorBody), status);
    }

    @ExceptionHandler(BadRequestLocalizedException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleBadRequestLocalizedException(BadRequestLocalizedException ex, Locale locale) {
        return buildResponseEntity(ex, HttpStatus.BAD_REQUEST, locale);
    }

    @ExceptionHandler(UnauthorizedLocalizedException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleUnauthorizedLocalizedException(UnauthorizedLocalizedException ex, Locale locale) {
        return buildResponseEntity(ex, HttpStatus.UNAUTHORIZED, locale);
    }

    @ExceptionHandler(ForbiddenLocalizedException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleForbiddenLocalizedException(ForbiddenLocalizedException ex, Locale locale) {
        return buildResponseEntity(ex, HttpStatus.FORBIDDEN, locale);
    }

    @ExceptionHandler(NotFoundLocalizedException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleNotFoundLocalizedException(NotFoundLocalizedException ex, Locale locale) {
        return buildResponseEntity(ex, HttpStatus.NOT_FOUND, locale);
    }

    @ExceptionHandler(ConflictLocalizedException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleConflictLocalizedException(ConflictLocalizedException ex, Locale locale) {
        return buildResponseEntity(ex, HttpStatus.CONFLICT, locale);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<UnsuccessfulResponseBody> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Set<ErrorBody> errorBodies = ex.getFieldErrors()
                                       .stream()
                                       .map(error -> ErrorBody.builder()
                                                              .code(extractErrorCode(error))
                                                              .message(error.getDefaultMessage())
                                                              .build())
                                       .collect(Collectors.toSet());

        return new ResponseEntity<>(new UnsuccessfulResponseBody(errorBodies), HttpStatus.BAD_REQUEST);
    }

    private String extractErrorCode(FieldError error) {
        String validationCode = error.getCode();
        String field = StringUtils.capitalize(error.getField().replaceAll("\\W", ""));

        return ParsingUtils.reconcatenateCamelCase(validationCode + "ValidationFailedFor" + field, "_")
                           .toUpperCase();
    }
}
