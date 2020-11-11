package com.example.suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectClasses({ UseTags.class })
@SelectPackages("com.example.tags")
@IncludeTags({ "functional" })
//@ExcludeTags({"load"})
//@IncludeCategory({FunctionalTest.class})
//@ExcludeCategory(LoadTest.class)
//@SelectPackages
public class UseTestSuite {

}
// -Dgroups="stress,functional"
