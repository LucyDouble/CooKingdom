package ckd.order.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import ckd.member.vo.User;
import ckd.order.service.OrderService;
import ckd.order.vo.OrderList;
import ckd.order.vo.Orders;

/**
 * Servlet implementation class OrderListInquiryPeriod
 */
@WebServlet("/orderListInquiryPeriod")
public class OrderListInquiryPeriod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderListInquiryPeriod() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService sv = new OrderService();

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("User");

		String periodStr = request.getParameter("period");
		int period = 0;
		

		
		if(periodStr.equals("today")) {
			period = 0;
		}else if(periodStr.equals("week")) {
			period = 7;
		}else if(periodStr.equals("month")) {
			period = 30;
		}else if(periodStr.equals("half")) {
			period = 180;
		}else if(periodStr.equals("whole")) {
			period = 365;
		}else {
			System.out.println("period 세션 값 오류");
		}

		Orders ordersVo = new Orders();

		List<OrderList> orderList = null;

		if (user.getEmail() != null) {
			ordersVo.setEmail(user.getEmail());
			orderList = sv.selectOrderList(ordersVo, period);
		} else {
			System.out.println("User의 email이 Null입니다.");
		}
		

		// JsonObject 생성
		JsonObject jsonObject = new JsonObject();
		try {
			JsonArray jArray = new JsonArray();
			for(int i =0; i<orderList.size(); i++) {
				JsonObject jobj = new JsonObject();
				jobj.addProperty("orderCode", orderList.get(i).getOrderCode());
				jobj.addProperty("email", orderList.get(i).getEmail());
				jobj.addProperty("shipCode", orderList.get(i).getShipCode());
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				String orderDate = df.format(orderList.get(i).getOrderDate());
				jobj.addProperty("orderDate", orderDate);
				jobj.addProperty("totalPrice", orderList.get(i).getTotalPrice());
				jobj.addProperty("mealkitQty", orderList.get(i).getMealkitQty());
				jobj.addProperty("recipeName", orderList.get(i).getRecipeName());
				jobj.addProperty("recipeUrl", orderList.get(i).getRecipeUrl());
				jobj.addProperty("price", orderList.get(i).getPrice());
				jArray.add(jobj);
			}
			jsonObject.add("orderList", jArray);
		} catch (NullPointerException e) {
			System.out.println("OrderList 불러오기 실패");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonOutput = gson.toJson(jsonObject);
		
		response.getWriter().write(jsonOutput.toString());
//		for (int i = 0; i < orderList.size(); i++) {
//			orderDate = df.format(orderList.get(i).getOrderDate());
//			
//			jobj.put("orderCode"+i, orderList.get(i).getOrderCode());
//			jobj.put("email"+i, orderList.get(i).getEmail());
//			jobj.put("shipCode"+i, orderList.get(i).getShipCode());
//			jobj.put("orderDate"+i, orderDate);
//			jobj.put("totalPrice"+i, orderList.get(i).getTotalPrice());
//			jobj.put("recipeCode"+i, orderList.get(i).getRecipeCode());
//			jobj.put("mealkitQty+i", orderList.get(i).getMealkitQty());
//			
//		}
		
		
		
//		PrintWriter out = response.getWriter();
//		
//		out.print(jobj.toJSONString());
//		out.flush();
//		out.close();
	}

}
