package webspider;

public interface LinkFilter {
	public boolean accept(String url);
}
