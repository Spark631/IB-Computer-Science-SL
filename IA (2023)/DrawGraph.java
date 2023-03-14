import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawGraph extends JPanel {

   private static final long serialVersionUID = 1L;

   private static final int WIDTH = 1000;
   private static final int HEIGHT = 1000;

   private LinkedHashMap<String, Double> data;

   public DrawGraph(LinkedHashMap<String, Double> data) {
      this.data = data;
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g.create();

      // Set rendering hints to improve quality
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

      // Draw x-axis
      g2d.drawLine(50, HEIGHT - 50, WIDTH - 50, HEIGHT - 50);

      // Draw y-axis
      g2d.drawLine(50, 50, 50, HEIGHT - 50);

      // Determine range of data values
      double maxVal = Double.MIN_VALUE;
      double minVal = Double.MAX_VALUE;
      for (Entry<String, Double> entry : data.entrySet()) {
         // Finds the max value of the linked hash map
         if (entry.getValue() > maxVal) {
            maxVal = entry.getValue();
         }
         // Finds the min value of the linked hash map
         if (entry.getValue() < minVal) {
            minVal = entry.getValue();
         }
      }
      double range = maxVal - minVal;

      // Draw y-axis labels
      int numLabels = 5; // Number of labels to draw on y-axis
      double labelIncrement = range / (numLabels - 1);
      int labelYIncrement = (HEIGHT - 100) / (numLabels - 1);
      for (int i = 0; i < numLabels; i++) {
         double labelVal = minVal + (i * labelIncrement);
         String labelText = String.format("%.0f", labelVal);
         g2d.drawString(labelText, 20, (HEIGHT - 70) - (i * labelYIncrement));
      }

      // Draw x-axis labels
      int x = 50;
      int stepSize = 10; // display every second date
      for (int i = 0; i < data.size(); i += stepSize) {
         Entry<String, Double> entry = (Entry<String, Double>) data.entrySet().toArray()[i];
         g2d.drawString(entry.getKey(), x - 15, HEIGHT - 30);
         x += ((WIDTH - 100) / data.size()) * stepSize;
      }

      // Draw data points and lines
      g2d.setColor(Color.RED);
      x = 50;
      int y, prevX = 0, prevY = 0;
      boolean isFirst = true;
      for (Entry<String, Double> entry : data.entrySet()) {
         y = (int) ((HEIGHT - 100) - ((entry.getValue() - minVal) * ((HEIGHT - 100) / range)));
         g2d.fillOval(x - 3, y - 3, 6, 6);
         if (!isFirst) {
            g2d.drawLine(prevX, prevY, x, y);
         } else {
            isFirst = false;
         }
         prevX = x;
         prevY = y;
         x += (WIDTH - 100) / data.size();
      }

      g2d.dispose();
   }

   public void graph(LinkedHashMap<String, Double> data) {
      // Create test data
      // Create and show graph
      JFrame frame = new JFrame("Graph");
      // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      DrawGraph panel = new DrawGraph(data);
      frame.add(panel);
      frame.pack();
      frame.setVisible(true);
   }

}