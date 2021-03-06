/*******************************************************************************
 *     Cloud Foundry
 *     Copyright (c) [2009-2015] Pivotal Software, Inc. All Rights Reserved.
 *
 *     This product is licensed to you under the Apache License, Version 2.0 (the "License").
 *     You may not use this product except in compliance with the License.
 *
 *     This product includes a number of subcomponents with
 *     separate copyright notices and license terms. Your use of these
 *     subcomponents is subject to the terms and conditions of the
 *     subcomponent's license, as noted in the LICENSE file.
 *******************************************************************************/
package org.cloudfoundry.identity.uaa.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String writeValueAsString(Object object) throws JsonUtilException {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new JsonUtilException(e);
        }
    }

    public static byte[] writeValueAsBytes(Object object) throws JsonUtilException {
        try {
            return objectMapper.writeValueAsBytes(object);
        } catch (IOException e) {
            throw new JsonUtilException(e);
        }
    }

    public static <T> T readValue(String s, Class<T> clazz) throws JsonUtilException {
        try {
            return objectMapper.readValue(s, clazz);
        } catch (IOException e) {
            throw new JsonUtilException(e);
        }
    }

    public static <T> T readValue(String s, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(s, typeReference);
        } catch (IOException e) {
            throw new JsonUtilException(e);
        }
    }

    public static class JsonUtilException extends RuntimeException {

        private static final long serialVersionUID = -4804245225960963421L;

        public JsonUtilException(Throwable cause) {
            super(cause);
        }

    }

}
