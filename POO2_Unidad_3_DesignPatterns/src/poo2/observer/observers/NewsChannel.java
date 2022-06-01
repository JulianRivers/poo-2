package poo2.observer.observers;

public class NewsChannel implements Channel{

	private String name;
	private String news;
	
	public NewsChannel(String name) {
		this.name = name;
	}
	
	public void setNews(String news) {
		this.news = news;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void update(Object news) {
		this.setNews((String) news);
		System.out.println("Channel "+name+" was notified about "+this.news);
	}

}
