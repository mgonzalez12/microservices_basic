package com.springboot.app.zuul.server.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);
	
	@Override
	public boolean shouldFilter() {
		// valida si se ejecuta el filro o no
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// Logica del filtro 
		
		RequestContext ctx = RequestContext.getCurrentContext(); //objeto contecto
		HttpServletRequest request = ctx.getRequest();
		log.info("Entrando a post filter");
		
		Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTranscurrido = tiempoFinal - tiempoInicio;
		
		log.info(String.format("Tiempo transcurrido en segundos %s sg", tiempoTranscurrido.doubleValue()/1000.00));
		log.info(String.format("Tiempo transcurrido en milesegundos %s ms", tiempoTranscurrido/1000));
		
		return null;
	}

	@Override
	public String filterType() {
		// tipo pre - antes de la comunicacion con el microservice
		return "post";
	}

	@Override
	public int filterOrder() {
		// El Orden
		return 1;
	}

}
