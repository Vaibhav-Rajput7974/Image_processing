package com.example.Image_processing_app;

import com.example.Image_processing_app.app1.commandDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
				"combine --operation1 remove-bg--operation2 resize  image.jpg"
		};

		for (String command : commands){
			commandDecoder.parseCommand(command);
		}
	}


}
