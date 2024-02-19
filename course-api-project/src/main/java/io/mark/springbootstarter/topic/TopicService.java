package io.mark.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;


@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("javascript", "JavaScript", "JavaScript Description")
			));
		
	public List<Topic> getAllTopics() {
		
		return topics;
		
	}
	
	public Topic getTopic(final String id) {
		
		return topics.stream().filter(new Predicate<Topic>() {
			public boolean test(Topic t_variable) {
				return t_variable.getId().equals(id);
			}
		}).findFirst().get();
				
	}

	public void addTopic(Topic topic) {
	
		topics.add(topic);
		
	}
	
	public void updateTopic(String id, Topic topic) {

		for(int i = 0; i < topics.size(); i++) {
			
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
			
		}
		
	}

	public void deleteTopic(final String id) {

		topics.removeIf(new Predicate<Topic>() {
			public boolean test(Topic t_variable) {
				return t_variable.getId().equals(id);
			}
		});
				
	}
	
	
}
