package com.example.Image_processing_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImageProcessingAppApplication  {


	public static void main(String[] args) {
		SpringApplication.run(ImageProcessingAppApplication.class, args);
		String[] commands = {"resize --width 800 --height 600 image.jpg",
				"extend --direction right --pixels 300 image.jpg",
				"crop --top 10 --right 10 --bottom 50 --left 50 image.jpg",
				"remove-bg image.jpg",
				" store --service google-drive --path /MyImages/result.jpg image.jpg",
				"combine --operation1 remove-bg--operation2 resize  image.jpg"
		};

		for (String command : commands){
			CommandDecoder.parseCommand(command);
		}
	}
}
