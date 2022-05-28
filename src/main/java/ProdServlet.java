import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


// http://localhost:8080/client2/first_servlet
@WebServlet(name = "ProdServlet", urlPatterns = "/show_products")
public class ProdServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProdServlet.class);


    ArrayList<Product> prod = initProd();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < prod.size(); i++) {
            resp.getWriter().printf("<h2>Номер  " + prod.get(i).getId()+"  Продукт  " + prod.get(i).getName()+ " Цена " + prod.get(i).getPrice());
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }



    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }

    private ArrayList<Product> initProd() {
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Хлеб", 43L));
        products.add(new Product(2L, "Квас", 13L));
        products.add(new Product(3L, "Молоко", 50L));
        products.add(new Product(4L, "Пиво", 57L));
        products.add(new Product(5L, "Колбаса", 200L));
        products.add(new Product(6L, "Масло", 78L));
        products.add(new Product(7L, "Сельдь", 55L));
        products.add(new Product(8L, "Вино", 500L));
        products.add(new Product(9L, "Икра заморская", 40L));
        products.add(new Product(10L, "Икра чёрная", 4000L));


        return products;
    }

}

