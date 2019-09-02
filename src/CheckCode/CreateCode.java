package CheckCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateCode")
public class CreateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 7.绂佹娴忚鍣ㄧ紦瀛橀殢鏈哄浘鐗�
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        // 6.閫氱煡瀹㈡埛鏈轰互鍥剧墖鏂瑰紡鎵撳紑鍙戦�佽繃鍘荤殑鏁版嵁
        response.setHeader("Content-Type", "image/jpeg");
        // 1.鍦ㄥ唴瀛樹腑鍒涘缓涓�骞呭浘鐗�
        BufferedImage image = new BufferedImage(110, 30,
                BufferedImage.TYPE_INT_BGR);
        // 2.鍚戝浘鐗囦笂鍐欐暟鎹�
        Graphics g = image.getGraphics();
        // 璁捐儗鏅壊
        g.setColor(Color.white);
        g.fillRect(0, 0, 110, 30);

        String checkcode = "";
        // 鐢�5涓獙璇佺爜瀛楃
        for(int i=0;i<5;i++){
            g.setColor(generateColor());
            g.setFont(generateFont());
            String str = generateStr();
            checkcode += str;
            g.drawString(str,20*i,25);
        }

        // 鐢诲共鎵扮偣
        for(int i=0;i<100;i++){
            Random random = new Random();
            int x = random.nextInt(110);
            int y = random.nextInt(30);
            g.setColor(generateColor());
            g.fillOval(x, y, 2, 2);
        }
        // 鐢诲共鎵扮嚎
        for(int i=0;i<5;i++){
            Random random = new Random();
            int x1 = random.nextInt(110);
            int y1 = random.nextInt(30);
            int x2 = random.nextInt(110);
            int y2 = random.nextInt(30);
            g.setColor(generateColor());
            g.drawLine(x1, y1, x2, y2);
        }
        // 杩欏彞璇濆氨鏄妸闅忔満鐢熸垚鐨勯獙璇佺爜锛屼繚瀛樺埌session
        // 楠岃瘉鐮佷笉鍖哄垎澶у皬鍐欙紝鎵�浠ヨ繖閲岃浆涓哄皬鍐�
        request.getSession().setAttribute("CreatCode", checkcode.toLowerCase());

        // 5.鎶婂啓濂芥暟鎹殑鍥剧墖杈撳嚭缁欐祻瑙堝櫒
        ImageIO.write(image, "jpg", response.getOutputStream());

    }

    /**
     * 鐢熸垚闅忔満瀛椾綋
     * @return
     */
    public Font generateFont() {
        String[] font_names = new String[] { "Broadway", "鏂规濮氫綋",
                "Footlight MT Light", "Sitka Text", "鏂规鑸掍綋", "骞煎渾" ,"Colonna MT"};
        int[] font_styles = new int[]{Font.BOLD, Font.ITALIC, Font.BOLD|Font.ITALIC};

        Random random = new Random();
        int name_index = random.nextInt(font_names.length);
        int style_index = random.nextInt(font_styles.length);

        return new Font(font_names[name_index],font_styles[style_index],28);
    }

    /**
     * 鐢熸垚闅忔満棰滆壊
     * 
     * @return
     */
    public Color generateColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256),
                random.nextInt(256));
    }

    /**
     * 鐢熸垚闅忔満鏁癧0-9a-zA-Z]
     * 
     * @return
     */
    public String generateStr() {
        String[] nums = new String[62];
        // 娣诲姞0-9杩�10涓暟瀛�
        for (int i = 0; i < 10; i++) {
            nums[i] = String.valueOf(i);
        }
        // 娣诲姞A-Z杩�26涓ぇ鍐欏瓧姣�
        for (int i = 65; i < 91; i++) {
            nums[i - 55] = Character.toString((char) i);
        }
        // 娣诲姞a-z杩�26涓皬鍐欏瓧姣�
        for (int i = 97; i < 123; i++) {
            nums[i - 61] = Character.toString((char) i);
        }
        // 浜х敓涓�涓殢鏈烘暟
        Random random = new Random();
        int index = random.nextInt(62);
        return nums[index];
		
		
		
		
	}

}
