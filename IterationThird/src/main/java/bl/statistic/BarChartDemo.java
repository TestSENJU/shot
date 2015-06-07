package bl.statistic;

import java.io.*;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * 该类用于演示最简单的柱状图生成
 */
public class BarChartDemo {
	public static void main(String[] args) throws IOException {
		CategoryDataset dataset = getDataSet2();
		JFreeChart chart = ChartFactory.createBarChart3D("水果产量图", // 图表标题
				"水果", // 目录轴的显示标签
				"产量", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
				);
		FileOutputStream fos_jpg = null;
		try {
			fos_jpg = new FileOutputStream("D:\\fruit.jpg");

			ChartUtilities.writeChartAsJPEG(fos_jpg, chart, 400, 300);
		} finally {
			try {
				fos_jpg.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 获取一个演示用的简单数据集对象
	 * 
	 * @return
	 */
	private static CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, null, "苹果");
		dataset.addValue(200, null, "梨子");
		dataset.addValue(300, null, "葡萄");
		dataset.addValue(400, null, "香蕉");
		dataset.addValue(500, null, "荔枝");
		return dataset;
	}

	/**
	 * 获取一个演示用的组合数据集对象
	 * 
	 * @return
	 */
	private static CategoryDataset getDataSet2() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, "北京", "苹果");
		dataset.addValue(100, "上海", "苹果");
		dataset.addValue(100, "广州", "苹果");
		dataset.addValue(200, "北京", "梨子");
		dataset.addValue(200, "上海", "梨子");
		dataset.addValue(200, "广州", "梨子");
		dataset.addValue(300, "北京", "葡萄");
		dataset.addValue(300, "上海", "葡萄");
		dataset.addValue(300, "广州", "葡萄");
		dataset.addValue(400, "北京", "香蕉");
		dataset.addValue(400, "上海", "香蕉");
		dataset.addValue(400, "广州", "香蕉");
		dataset.addValue(500, "北京", "荔枝");
		dataset.addValue(500, "上海", "荔枝");
		dataset.addValue(500, "广州", "荔枝");
		return dataset;
	}
}
