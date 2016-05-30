package com.ascentialdata.service.rest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Level;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.filter.LoggingFilter;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

import com.ascentialdata.service.rest.entity.Pong;

@Path("rest")
public class DannyService {

	@GET
	@Produces("application/xml")
	@Path("/ping")
	public Pong ping() {

		return new Pong();
	}

	@GET
	@Produces("text/plain")
	@Path("/{name}")
	public StreamingOutput getBytes(@PathParam("name") String name) {
		return new StreamingOutput() {
			@Override
			public void write(OutputStream output) throws IOException, WebApplicationException {
				String a = name;
				output.write(name.getBytes());
			}
		};

	}
	
	
	
	
	

	@PUT
	@Path("/stuff")
	public void putStuff(InputStream is) throws IOException {
		byte[] bytes = readFromStream(is);
		String input = new String(bytes);
		System.out.println(input);
	}

	private byte[] readFromStream(InputStream stream) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1000];
		int wasRead = 0;
		do {
			wasRead = stream.read(buffer);
			if (wasRead > 0) {
				baos.write(buffer, 0, wasRead);
			}
		} while (wasRead > -1);
		return baos.toByteArray();
	}

}
