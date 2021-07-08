# StripedProcessButton
It's an HarmonyOS library that provides an Animated striped button to show the loading process.

## Source
Inspired by https://github.com/nikartm/StripedProcessButton Version v2.0.0

## Screenshot
<img src = "https://github.com/alpesh12345/StripedProcessButton/blob/main/screenshots/stripedprocessbutton.gif"/>

## Features
It provides an animated striped button that appears to be normal (depends on you to show or hide strips) but when clicked it gets animated according to attributes to show the loading process. 
* Different colors can be configured for a button background, main strip, and sub strip.  
* You can configure the text that needs to be displayed while the button is in the loading state and gets changed to normal button text when stopped. 
* Here you get the option to use GradientShader or just a normal shader (spb_stripeGradient is used to set it).<br>
Can observe both buttons clicked in the gif, they are set to true for stripe gradient and others are using a normal linear shader.
* You can configure the corner radius for the button and the button will get a rounded corner accordingly. 
* No need to use the different graphic file for a button background, all features about setting the background color to corner radius are included over here. 
* This provides the user with the option to configure the amount of tilt on the strip while it is animating. 
* Strip width and tilt revert can also be configured. 
* All these functionalities can also be adjusted programmatically, a related snippet is shown in the Usage section.
## Installation Instructions
1.For using StripedProcessButton module in sample app, include the source code and add the below dependencies in entry/build.gradle to generate hap/support.har.
```
	dependencies {
		implementation project(':support')
        	implementation fileTree(dir: 'libs', include: ['*.har'])
        	testCompile 'junit:junit:4.12'
	}
```
2.For using StripedProcessButton in separate application using har file, add the har file in the entry/libs folder and add the dependencies in entry/build.gradle file.
```
	dependencies {
		implementation fileTree(dir: 'libs', include: ['*.har'])
		testCompile 'junit:junit:4.12'
	}
```
## Usage
Adjust the xml view
```
<com.alpesh.strippedprocessbutton.StripedProcessButton
        ohos:id="$+id:btn_start"
        ohos:left_margin="16fp"
        ohos:right_margin="16fp"
        ohos:width="match_parent"
        ohos:height="60fp"
        ohos:layout_alignment="center"
        ohos:top_margin="40fp"
        ohos:text_size="20fp"
        ohos:text="StartProcess"
        ohos:text_font="sans-serif"
        ohos:text_weight="700"
        app:spb_showStripes="false"
        app:spb_loadingText="Buffer..."
        app:spb_cornerRadius="25"
        ohos:clickable="true"
        ohos:focusable="focus_enable"
        ohos:text_color="#FFF1F1F0"
        />
```
Adjust programmatically (shortly):
```
stripedButton.setCornerRadius(50)
        .setStripeAlpha(0.7f)
        .setStripeRevert(true)
        .setStripeGradient(false)
        .setTilt(15)
        .start();
```
## Future work
Circular Reveal animation for button feature is currently not supported. One's platform includes this, it can be integrated here.
## License
Copyright 2018 Ivan Vodyasov

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
```
http://www.apache.org/licenses/LICENSE-2.0
```
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
