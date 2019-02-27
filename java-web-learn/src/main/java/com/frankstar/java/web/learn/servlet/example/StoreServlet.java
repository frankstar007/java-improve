package com.frankstar.java.web.learn.servlet.example;

import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author :  frankstar
 * @AddTime :  2019/2/25
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@WebServlet(
	name = "storeServlet",
	urlPatterns = "/shop"
)
public class StoreServlet extends HttpServlet {

	private final Map<Integer, String> product = Maps.newHashMap();

	public StoreServlet() {
		this.product.put(1, "SandPaper");
		this.product.put(2, "Nails");
		this.product.put(3, "Glue");
		this.product.put(4, "Paint");
		this.product.put(5, "Tape");

	}


	@Override
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		this.doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null) {
			action = "browse";
		}
		
		switch (action) {
			case "addCart":
				this.addCart(request, response);
				break;
			case "viewCart":
				this.viewCart(request, response);
				break;
			case "browse":
			default:
				this.browse(request, response);
				break;
		}
	}

	private void browse(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setAttribute("product", this.product);
		request.getRequestDispatcher("/WEB-INF/jsp/view/browse.jsp")
			.forward(request, response);
	}

	private void viewCart(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setAttribute("product", this.product);
		request.getRequestDispatcher("/WEB-INF/jsp/view/viewCart.jsp")
			.forward(request, response);
	}

	private void addCart(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
		int productId;
		try {

			productId = Integer.parseInt(request.getParameter("productId"));
		} catch (Exception e) {
			response.sendRedirect("/shop");
			return;
		}

		HttpSession session = request.getSession();
		if (session.getAttribute("cart") == null) {
			session.setAttribute("cart", new Hashtable<Integer, Integer>());
		}

		Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
		if (!cart.containsKey(productId)) {
			cart.put(productId, 0);
		}
		cart.put(productId, cart.get(productId) + 1);

		response.sendRedirect("shop?action=viewCart");

	}
}
