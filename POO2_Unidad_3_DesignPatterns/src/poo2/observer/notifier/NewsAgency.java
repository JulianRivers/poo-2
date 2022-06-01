package poo2.observer.notifier;

import java.util.ArrayList;
import java.util.List;

import poo2.observer.observers.Channel;

public class NewsAgency {

	private String name;
	private String news;
	private List<Channel> channels = new ArrayList<>();

	public NewsAgency(String name) {
		this.name = name;
	}
	
	public void addObserver(Channel channel) {
		this.channels.add(channel);
	}

	public void removeObserver(Channel channel) {
		this.channels.remove(channel);
	}

	public void setNews(String news) {
		this.news = news;
		for (Channel channel : this.channels) {
			channel.update(this.news);
		}
	}
	
	public String getName() {
		return name;
	}

}
