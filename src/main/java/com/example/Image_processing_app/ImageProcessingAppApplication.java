package com.example.Image_processing_app;

import com.example.Image_processing_app.app1.Command;
import com.example.Image_processing_app.app1.Image;
import com.example.Image_processing_app.app1.adpter.Adapter;
import com.example.Image_processing_app.app1.decorator.OperationDecorator;
import com.example.Image_processing_app.app1.operation.BackGroupRemove;
import com.example.Image_processing_app.app1.operation.Crop;
import com.example.Image_processing_app.app1.operation.Operation;
import com.example.Image_processing_app.app1.statePattern.PayPal;
import com.example.Image_processing_app.app1.statePattern.PaymentPlateForm;
import com.example.Image_processing_app.app1.stratage.AwsService;
import com.example.Image_processing_app.app1.stratage.ServiceProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class ImageProcessingAppApplication  {

//	public static void main(String[] args) {
////		ServiceProvider awsService = new AwsService();
////		Adapter adapter = new Adapter(awsService);
////		Operation backgroundRemover = new BackGroupRemove(adapter,new Crop(adapter));
////		int charges = backgroundRemover.charges();
////		PaymentPlateForm paypal = new PayPal();
////		paypal.pay(charges);
////		backgroundRemover.process(new Image("animal",null,"PNG"));
//////		OperationDecorator cropandGenerateAI = new
//	}


	public static void main(String[] args) {
		SpringApplication.run(ImageProcessingAppApplication.class, args);
		String[] commands = {"resize --width 800 --height 600 image.jpg",
				"extend --direction right --pixels 300 image.jpg",
				"crop --top 10 --right 10 --bottom 50 --left 50 image.jpg",
				"remove-bg image.jpg",
				" store --service google-drive --path /MyImages/result.jpg image.jpg",
				"combine --operation1 remove-bg --operation2 resize --width 800 --height 600 image.jpg"
		};

		for (String command : commands){
			Command.parseCommand(command);
		}
	}


}
