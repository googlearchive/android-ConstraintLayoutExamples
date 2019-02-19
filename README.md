MotionLayout / Constraint Layout Samples
=========================
This repository contains a list of layouts that showcases the various features and usage of
[ConstraintLayout](https://developer.android.com/reference/android/support/constraint/ConstraintLayout.html) and 
[MotionLayout](https://developer.android.com/reference/android/support/constraint/motion/MotionLayout)

Pre-requisites
--------------
- Android Studio 3.3+
- Constaint Layout library 2.0.0-alpha3+

Getting Started
---------------
Import the project using Android Studio. Navigate to the app>res>layout> and open one of the layouts
in the layout editor. This sample is best understood by seeing the constraints in the Design mode
of the layout editor.

MotionLayout samples overview
-----------------------------

|  Title  |  GIF  | Layout XML | MotionScene XML | 
| :----: | :----: | :----: | :----: |
|  Basic Example (1/2) | <img src="art/motionlayout-1-basic-example.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_01_basic.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_01.xml) | 
|  Basic Example (2/2) | <img src="art/motionlayout-2-basic-example.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_02_basic.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_02.xml) | 
|  Custom Attribute | <img src="art/motionlayout-3-custom-attribute.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_03_custom_attribute.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_03.xml) | 
|  ImageFilterView (1/2) | <img src="art/motionlayout-4-imagefilterview1.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_04_imagefilter.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_04.xml) | 
|  ImageFilterView (2/2) | <img src="art/motionlayout-5-imagefilterview2.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_05_imagefilter.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_05.xml) | 
|  Keyframe Position (1/3) | <img src="art/motionlayout-6-keyframe-position.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_06_keyframe.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_06.xml) | 
|  Keyframe Interpolation (2/3) | <img src="art/motionlayout-7-keyframe-interpolation.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_07_keyframe.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_07.xml) | 
|  Keyframe Cycle (3/3) | <img src="art/motionlayout-8-keyframe-keycycle.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_08_cycle.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_08.xml) | 
|  CoordinatorLayout Example (1/3) | <img src="art/motionlayout-9-coordinator-layout-example1.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_09_coordinatorlayout.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_09.xml) | 
|  CoordinatorLayout Example (2/3) | <img src="art/motionlayout-10-coordinator-layout-example2.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_10_coordinatorlayout.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_10.xml) | 
|  CoordinatorLayout Example (3/3) | <img src="art/motionlayout-11-coordinator-layout-example3.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_11_coordinatorlayout.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_11.xml) | 
|  DrawerLayout Example (1/2) | <img src="art/motionlayout-12-drawerlayout-example1.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_12_drawerlayout.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_12_content.xml) | 
|  DrawerLayout Example (2/2) | <img src="art/motionlayout-13-drawerlayout-example2.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_13_drawerlayout.xml) | [Content](motionlayout/src/main/res/xml/scene_12_content.xml) <br> [Menu](motionlayout/src/main/res/xml/scene_13_menu.xml)| 
|  Side Panel Example | <img src="art/motionlayout-14-sidepanel-example.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_14_side_panel.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_14.xml) | 
|  Parallax Example | <img src="art/motionlayout-15-parallax-example.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_15_parallax.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_15.xml) | 
|  ViewPager Example | <img src="art/motionlayout-16-viewpager-example.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_16_viewpager.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_15.xml) | 
|  ViewPager Lottie Example | <img src="art/motionlayout-17-viewpager-lottie-example.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_23_viewpager.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_23.xml) | 
|  Complex Motion Example (1/4) | <img src="art/motionlayout-18-complex-example1.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_17_coordination.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_17.xml) | 
|  Complex Motion Example (2/4) | <img src="art/motionlayout-19-complex-example2.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_18_coordination.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_18.xml) | 
|  Complex Motion Example (3/4) | <img src="art/motionlayout-20-complex-example3.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_19_coordination.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_19.xml) | 
|  Complex Motion Example (4/4) | N/A | [Layout](motionlayout/src/main/res/layout/motion_20_reveal.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_20.xml) | 
|  Fragment Transition Example (1/2) | <img src="art/motionlayout-22-fragment-transition1.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/main_activity.xml) | [MotionScene](motionlayout/src/main/res/xml/main_scene.xml) |
|  Fragment Transition Example (2/2) | <img src="art/motionlayout-23-fragment-transition2.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/main_activity.xml) | [MotionScene](motionlayout/src/main/res/xml/main_scene.xml) |  
|  YouTube like motion Example | <img src="art/motionlayout-25-youtube.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_24_youtube.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_24.xml) |  
|  Example using KeyTrigger | <img src="art/motionlayout-26-keytrigger.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_25_keytrigger.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_25.xml) |  
|  Example using Multi State | <img src="art/motionlayout-27-multistate.gif" height="360" width="180" > | [Layout](motionlayout/src/main/res/layout/motion_26_multistate.xml) | [MotionScene](motionlayout/src/main/res/xml/scene_26.xml) |  


ConstraintLayout samples screenshots
------------

![Constraint Set Example](screenshots/constraint_set_example.png "Constraint Set Example")
![Advanced Chains Example](screenshots/advanced_chains.png "Advanced usage of Chains")

Support
-------
If you've found an error in this sample, please file an issue:
https://github.com/googlesamples/android-ConstraintLayoutExamples/issues

To learn more about ConstraintLayout checkout the
[Constraint Layout Training Guide](https://developer.android.com/training/constraint-layout/index.html)

Patches are encouraged, and may be submitted by forking this project and
submitting a pull request through GitHub. Please see the [contributing guidelines](CONTRIBUTING.md) for more details.

License
-------

Copyright 2017 The Android Open Source Project, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
