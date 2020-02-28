package com.car.booking.controller.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class SystemMessageDto implements JsonSerializable {

  private HttpStatus status;
  private String error;
  private String message;

  public SystemMessageDto(HttpStatus status, String error, String message) {
    this.status = status;
    this.error = error;
    this.message = message;
  }

  @Override
  public void serialize(JsonGenerator jgen, SerializerProvider provider) throws IOException {
    jgen.writeStartObject();
    jgen.writeNumberField("status", status.value());
    jgen.writeStringField("error", error);
    jgen.writeStringField("message", message);
    jgen.writeEndObject();
    jgen.close();
  }

  @Override
  public void serializeWithType(JsonGenerator jgen, SerializerProvider provider,
      TypeSerializer typeSer) throws IOException {
    serialize(jgen, provider);
  }
}
