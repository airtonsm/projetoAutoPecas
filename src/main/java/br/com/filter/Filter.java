package br.com.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.entities.Usuario;
import br.com.jpaUtil.JpaUtil;

@WebFilter(urlPatterns = { "/*" })
public class Filter implements javax.servlet.Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		String url = req.getServletPath();
		
		if (!url.equalsIgnoreCase("index.jsf") && usuarioLogado == null) {
			RequestDispatcher disparcher = request.getRequestDispatcher("index.jsf");
			disparcher.forward(request, response);
			return;
		} else {
			// executa ações do request e response
			chain.doFilter(request, response);

		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		JpaUtil.getEntityManager(); // levanta a conexão

	}

}
