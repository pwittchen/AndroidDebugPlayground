Android Debug Playground
======================

Playing with hugo and loglifecycle - annotations, which helps with debugging Android projects.

#hugo

The following code:

```java
@DebugLog
public String getName(String first, String last) {
    SystemClock.sleep(15); // Don't ever really do this!
    return first + " " + last;
}
```

produces the following logs:

```
11-16 19:24:34.564    1203-1203/? D/MainActivity﹕ ⇢ getName(first="John", last="Doe")
11-16 19:24:34.580    1203-1203/? D/MainActivity﹕ ⇠ getName [15ms] = "John Doe"
```

#loglifecycle

The following `@LogLifecycle` annotation:

```java
@LogLifeCycle
public class MainActivity extends ActionBarActivity {
    //...
}
```

produces the following logs:

```
11-16 19:24:34.512    1203-1203/? D/LogLifeCycle﹕ pwittchen.com.androiddebugplayground.MainActivity [1384319084] ⟳ onApplyThemeResource
11-16 19:24:34.516    1203-1203/? D/LogLifeCycle﹕ pwittchen.com.androiddebugplayground.MainActivity [1384319084] ⟳ onWindowAttributesChanged
11-16 19:24:34.516    1203-1203/? D/LogLifeCycle﹕ pwittchen.com.androiddebugplayground.MainActivity [1384319084] ⟳ onWindowAttributesChanged
11-16 19:24:34.516    1203-1203/? D/LogLifeCycle﹕ pwittchen.com.androiddebugplayground.MainActivity [1384319084] ⟳ onWindowAttributesChanged
11-16 19:24:34.520    1203-1203/? D/LogLifeCycle﹕ pwittchen.com.androiddebugplayground.MainActivity [1384319084] ⟳ onWindowAttributesChanged
11-16 19:24:34.524    1203-1203/? D/LogLifeCycle﹕ pwittchen.com.androiddebugplayground.MainActivity [1384319084] ⟳ onCreate
11-16 19:24:34.524    1203-1203/? D/LogLifeCycle﹕ pwittchen.com.androiddebugplayground.MainActivity [1384319084] ⟳ onCreate
11-16 19:24:34.560    1203-1203/? D/LogLifeCycle﹕ pwittchen.com.androiddebugplayground.MainActivity [1384319084] ⟳ onSupportContentChanged
11-16 19:24:34.560    1203-1203/? D/LogLifeCycle﹕ pwittchen.com.androiddebugplayground.MainActivity [1384319084] ⟳ onStart
11-16 19:24:34.560    1203-1203/? D/LogLifeCycle﹕ pwittchen.com.androiddebugplayground.MainActivity [1384319084] ⟳ onTitleChanged
11-16 19:24:34.564    1203-1203/? D/LogLifeCycle﹕ pwittchen.com.androiddebugplayground.MainActivity [1384319084] ⟳ onResume
11-16 19:24:34.580    1203-1203/? D/LogLifeCycle﹕ pwittchen.com.androiddebugplayground.MainActivity [1384319084] ⟳ onResumeFragments
11-16 19:24:34.584    1203-1203/? D/LogLifeCycle﹕ pwittchen.com.androiddebugplayground.MainActivity [1384319084] ⟳ onPostResume
11-16 19:24:34.600    1203-1203/? D/LogLifeCycle﹕ pwittchen.com.androiddebugplayground.MainActivity [1384319084] ⟳ onAttachedToWindow
11-16 19:24:34.760    1203-1203/? D/LogLifeCycle﹕ pwittchen.com.androiddebugplayground.MainActivity [1384319084] ⟳ onWindowFocusChanged
```

You can filter these logs with `⟳` sign.

##build.gradle file

Please, take a look at [build.gradle](https://github.com/pwittchen/AndroidDebugPlayground/blob/master/app/build.gradle) file. Sometimes it may happen that project won't be built correctly. In such case, remove the following lines:

```
apply plugin: 'loglifecycle'
apply plugin: 'hugo'
```

After that, build project, so it can download dependencies and plugins. When build is complete, add lines mentioned above, and build project again.

##References
- hugo: https://github.com/JakeWharton/hugo
- loglifecycle: https://github.com/stephanenicolas/loglifecycle