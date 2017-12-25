# CoordinatorTest

这个Demo主要是用来测试CoordinatorLayout中AppbarLayout的ScrollFlags效果。

# ScrollFlags的五个类型：

1. SCROLL_FLAG_ENTER_ALWAYS
	
	When entering (scrolling on screen) the view will scroll on any downwards scroll event, regardless of whether the scrolling view is also scrolling.
    
    当((entering) / (scrolling on screen))下拉的时候，这个View也会跟着滑出。
    
2. SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED
	
	An additional flag for 'enterAlways' which modifies the returning view to only initially scroll back to it's collapsed height.

    另一种enterAlways，但是只显示折叠后的高度。

3. SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
	
	When exiting (scrolling off screen) the view will be scrolled until it is 'collapsed'.

    当((exiting) / (scrolling off screen))上拉的时候，这个View会跟着滑动直到折叠。

4. SCROLL_FLAG_SCROLL

	The view will be scroll in direct relation to scroll events.

    这个View将会响应Scroll事件
    
5. SCROLL_FLAG_SNAP
	
	Upon a scroll ending, if the view is only partially visible then it will be snapped and scrolled to it's closest edge.

    在Scroll滑动事件结束以前 ，如果这个View部分可见，那么这个View会停在最接近当前View的位置
    
# 结合项目

直接看上边5中flag的表述不容易理解每个的作用，结合本demo则可以直观的看出他们区别，用通俗的语言再描述一次：

1. SCROLL_FLAG_ENTER_ALWAYS

    当RecyclerView上滑时Toolbar隐藏，当RecyclerView下滑时Toolbar显示；

2. SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED

    当RecyclerView上滑时Toolbar隐藏，当RecyclerView下滑到顶部时Toolbar显示；（注意是顶部）

3. SCROLL_FLAG_EXIT_UNTIL_COLLAPSED

    这个没有试出效果，暂且不说；

4. SCROLL_FLAG_SCROLL

    要想使用其他4个flag，必须同时使用这个scroll；

5. SCROLL_FLAG_SNAP

    这个的效果跟SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED基本一样，只是在Toolbar显示和隐藏的时候有点区别：如果Toolbar显示"过半"则全部显示，隐藏"过半"则全部隐藏；
    
# ScrollFlags的设置方式

1. 在xml代码里直接设置

```
   <android.support.v7.widget.Toolbar
       android:id="@+id/toolbar"
       android:layout_width="match_parent"
       android:layout_height="?attr/actionBarSize"
       android:background="?attr/colorPrimary"
       app:layout_scrollFlags="scroll|enterAlwaysCollapsed"
       app:popupTheme="@style/AppTheme.PopupOverlay"
       />
```

2. 在java代码中设置

```
    Toolbar mToolbar = findViewById(R.id.toolbar);
    
    AppBarLayout.LayoutParams mLayoutParams = (AppBarLayout.LayoutParams) mToolbar.getLayoutParams();
    
    mLayoutParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                        | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
                        
    mToolbar.setLayoutParams(mLayoutParams);
```