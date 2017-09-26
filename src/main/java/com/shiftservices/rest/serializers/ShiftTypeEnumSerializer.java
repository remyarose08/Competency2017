package com.shiftservices.rest.serializers;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.shiftservices.datatype.ShiftType;


public class ShiftTypeEnumSerializer extends JsonSerializer<ShiftType> {

	@Override
	public void serialize(ShiftType value, JsonGenerator generator,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		generator.writeStartObject();
		generator.writeFieldName("name");
		generator.writeString(value.getName());
		generator.writeFieldName("loginTime");
		generator.writeString(value.getLoginTime());
		generator.writeFieldName("logoutTime");
		generator.writeString(value.getLogoutTime());
		generator.writeFieldName("amount");
		generator.writeNumber(value.getAmount());

		generator.writeEndObject();
	}
}
