package com.lankin.RESTfullSeviceApacheCXF.exception;

import java.io.Serializable;

/**
 * Class {@code ResourceNotFoundException} in package {@code com.lankin.rest.exception}
 *
 * RuntimeException for REST API
 *
 * @author Nikita Lankin
 * @version 1.0
 *
 */

public class ResourceNotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    /**
     * handler for exception
     *
     * @param resourceName Entity name
     * @param fieldName    Entity id
     * @param fieldValue   Object to return
     */
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}