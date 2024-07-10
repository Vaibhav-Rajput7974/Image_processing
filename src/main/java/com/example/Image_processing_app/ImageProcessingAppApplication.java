package com.example.Image_processing_app;

import com.example.Image_processing_app.command.Command;
import com.example.Image_processing_app.command.ImageProcess;
import com.example.Image_processing_app.command.RemoveBgCommand;
import com.example.Image_processing_app.command.ResizeCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImageProcessingAppApplication  {


	public static void main(String[] args) {
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

//
//	public static void main(String[] args) {
//
//		Command resizeCommand = new ResizeCommand(new RemoveBgCommand(new ImageProcess()));
//		resizeCommand.execute();
//
////		Command command = CombineCommand(new ResizeCommand(new ResizeCommand()));
////
////		ImageProcessing imageProcessing ;
////		imageProcessing.push(new Image(fileName,null,"JPG","0","100"));
////		imageProcessing.start();
//	}
}
