//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
///**
// * 相机测试
// */
//public class TestWebCam {
//
//	private static JFrame window;
//
//	public static void main(String[] args) throws InterruptedException {
//
//		Webcam webcam = Webcam.getDefault();
//		webcam.setViewSize(WebcamResolution.VGA.getSize());
//
//		WebcamPanel panel = new WebcamPanel(webcam);
//		panel.setFPSDisplayed(true);
//		panel.setDisplayDebugInfo(true);
//		panel.setImageSizeDisplayed(true);
//		panel.setMirrored(true);
//
//		JFrame window = new JFrame("Test webcam panel");
//		window.add(panel);
//		window.setResizable(true);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.pack();
//		window.setVisible(true);
//
//
//
//		final JButton button = new JButton("拍照");
//		window.add(panel, BorderLayout.CENTER);
//		window.add(button, BorderLayout.SOUTH);
//		window.setResizable(true);
//		window.pack();
//		window.setVisible(true);
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e)
//			{
//
//				button.setEnabled(false);  //设置按钮不可点击
//
//
//				//实现拍照保存-------start
//				String fileName = "D://" + System.currentTimeMillis();       //保存路径即图片名称（不用加后缀）
//				WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_PNG);
//				SwingUtilities.invokeLater(new Runnable() {
//
//					@Override
//					public void run()
//					{
//						JOptionPane.showMessageDialog(null, "拍照成功");
//						button.setEnabled(true);    //设置按钮可点击
//
//						return;
//					}
//				});
//				//实现拍照保存-------end
//
//			}
//		});
//	}
//
//
//
//
//}
//————————————————
//版权声明：本文为CSDN博主「蔡小波」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/qq_22078107/article/details/85927626