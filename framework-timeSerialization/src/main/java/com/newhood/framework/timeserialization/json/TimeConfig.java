package com.newhood.framework.timeserialization.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.*;

import static java.time.temporal.ChronoField.MILLI_OF_DAY;

/**
 * <p>
 *        时间处理器重写，全部将其按照时间戳进行处理
 * </p>
 * @author ZJW
 * @since 2020-10-16 14:51
 */
public class TimeConfig {

    /**
     * 序列化实现
     */
    public static JsonSerializer<LocalDateTime> getLocalDateTimeSerializer() {
        return new JsonSerializer<LocalDateTime>() {
            @Override
            public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers)
                    throws IOException {
                if (value != null) {
                    long timestamp = value.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    gen.writeNumber(timestamp);
                }
            }
        };
    }


    /**
     * 反序列化实现
     */
    public static JsonDeserializer<LocalDateTime> getLocalDateTimeDeserializer() {
        return new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonParser p, DeserializationContext deserializationContext)
                    throws IOException {
                long timestamp = p.getValueAsLong();
                if (timestamp > 0) {
                    return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
                } else {
                    return null;
                }
            }
        };
    }

    /**
     * 序列化实现
     */
    public static JsonSerializer<java.sql.Date> getSqlDateSerializer() {
        return new JsonSerializer<java.sql.Date>() {
            @Override
            public void serialize(java.sql.Date value, JsonGenerator gen, SerializerProvider serializers)
                    throws IOException {
                if (value != null) {
                    long timestamp = value.getTime();
                    gen.writeNumber(timestamp);
                }
            }
        };
    }

    /**
     * 反序列化实现
     */
    public static JsonDeserializer<java.sql.Date> getSqlDateDeserializer() {
        return new JsonDeserializer<java.sql.Date>() {
            @Override
            public java.sql.Date deserialize(JsonParser p, DeserializationContext deserializationContext)
                    throws IOException {
                long timestamp = p.getValueAsLong();
                if (timestamp > 0) {
                    return new java.sql.Date(timestamp);
                } else {
                    return null;
                }
            }
        };
    }

    /**
     * 序列化实现
     */
    public static JsonSerializer<java.util.Date> getUtilDateSerializer() {
        return new JsonSerializer<java.util.Date>() {
            @Override
            public void serialize(java.util.Date value, JsonGenerator gen, SerializerProvider serializers)
                    throws IOException {
                if (value != null) {
                    long timestamp = value.getTime();
                    gen.writeNumber(timestamp);
                }
            }
        };
    }

    /**
     * 反序列化实现
     */
    public static JsonDeserializer<java.util.Date> getUtilDateDeserializer() {
        return new JsonDeserializer<java.util.Date>() {
            @Override
            public java.util.Date deserialize(JsonParser p, DeserializationContext deserializationContext)
                    throws IOException {
                long timestamp = p.getValueAsLong();
                if (timestamp > 0) {
                    return new java.util.Date(timestamp);
                } else {
                    return null;
                }
            }
        };
    }

    /**
     * 序列化实现
     */
    public static JsonSerializer<LocalDate> getLocalDateSerializer() {
        return new JsonSerializer<LocalDate>() {
            @Override
            public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers)
                    throws IOException {
                if (value != null) {
                    long timestamp = value.atStartOfDay().toInstant(ZoneOffset.of("+8")).toEpochMilli();
                    gen.writeNumber(timestamp);
                }
            }
        };
    }

    /**
     * 反序列化实现
     */
    public static JsonDeserializer<LocalDate> getLocalDateDeserializer() {
        return new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonParser p, DeserializationContext deserializationContext)
                    throws IOException {
                long timestamp = p.getValueAsLong();
                if (timestamp > 0) {
                    return Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
                } else {
                    return null;
                }
            }
        };
    }

    /**
     * 序列化实现
     */
    public static JsonSerializer<LocalTime> getLocalTimeSerializer() {
        return new JsonSerializer<LocalTime>() {
            @Override
            public void serialize(LocalTime value, JsonGenerator gen, SerializerProvider serializers)
                    throws IOException {
                if(value != null ) {
                    long timestamp = value.getLong(MILLI_OF_DAY);
                    gen.writeNumber(timestamp);
                }
            }
        };
    }

    /**
     * 反序列化实现
     */
    public static JsonDeserializer<LocalTime> getLocalTimeDeserializer() {
        return new JsonDeserializer<LocalTime>() {
            @Override
            public LocalTime deserialize(JsonParser p, DeserializationContext deserializationContext)
                    throws IOException {
                long timestamp = p.getValueAsLong();
                if (timestamp > 0) {
                    return Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalTime();
                } else {
                    return null;
                }
            }
        };
    }

}
