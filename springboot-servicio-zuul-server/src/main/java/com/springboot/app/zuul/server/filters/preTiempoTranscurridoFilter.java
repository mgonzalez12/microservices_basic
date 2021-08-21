package com.springboot.app.zuul.server.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class preTiempoTranscurridoFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(preTiempoTranscurridoFilter.class);
	
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
		log.info(String.format("%s request enrutado a %s", request.getMethod(),request.getRequestURL().toString()));
		
		Long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		return null;
	}

	@Override
	public String filterType() {
		// tipo pre - antes de la comunicacion con el microservice
		return "pre";
	}

	@Override
	public int filterOrder() {
		// El Orden
		return 1;
	}

}
