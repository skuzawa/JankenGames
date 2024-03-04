package Controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultController
 */
@WebServlet("/janken")
public class ResultController extends HttpServlet {
	private int[] Janken(int hand, int num) {
		Random rand = new Random();
		
		int[] handInfo = new int[num + 2];				//[0]:プレイヤーのハンド [1~num]:cpのハンド [num+1]:プレイヤーの勝敗
		handInfo[0] = hand-1;								//0:グー 1:チョキ 2:パー
		
		Set<Integer> handsSet = new HashSet<>();		//場のハンドの種類の数
		handsSet.add(hand);
		int setSize = handsSet.size();
		
		for(int i = 1; i <= num; i++) {					//cpのハンドをランダムに格納
			handInfo[i] = rand.nextInt(3);
			handsSet.add(handInfo[i]);
		}

		if(setSize == 1 || setSize == 3) {				//0:引き分け 1:勝ち 2:負け
			handInfo[num + 1] = 0;						//場の手の種類が1 or 3種類なら「あいこ」
		}else if(handsSet.contains((hand + 1) % 3)){	//場の手の種類が2 and プレイヤーvsCP
			handInfo[num + 1] = 1;
		}else{
			handInfo[num + 1] = 2;
		}
		return handInfo;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int hand = Integer.parseInt(request.getParameter("hand"));
		int num = Integer.parseInt(request.getParameter("num"));
		int[] handInfo = Janken(hand,num);

		request.setAttribute("handInfo", handInfo);
		
		String view = "/WEB-INF/views/result.jsp";
        request.getRequestDispatcher(view).forward(request, response);
	}

}
