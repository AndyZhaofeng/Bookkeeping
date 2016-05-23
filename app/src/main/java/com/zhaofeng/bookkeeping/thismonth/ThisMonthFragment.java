package com.zhaofeng.bookkeeping.thismonth;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.zhaofeng.bookkeeping.R;
import com.zhaofeng.bookkeeping.data.model.ConsumeType;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhaofeng on 16/5/19.
 */
public class ThisMonthFragment extends Fragment implements ThisMonthContract.View
{
    public static final String ARGS="ThisMonthFragment";

    @BindView(R.id.thismonth_pie)
    PieChart pieChart;
    @BindView(R.id.thismonth_amount)
    TextView customAmount;

    private Typeface tf;
    private Context context;

    public static ThisMonthFragment newInstance(String title)
    {
        Bundle bundle=new Bundle();
        bundle.putString(ThisMonthFragment.ARGS,title);
        ThisMonthFragment fragment=new ThisMonthFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        this.context=context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.thismonth_layout,null);
        ButterKnife.bind(this,view);
        pieChart.setUsePercentValues(true);
        pieChart.setDescription("");
        pieChart.setExtraOffsets(5, 10, 5, 5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        tf = Typeface.createFromAsset(context.getAssets(), "OpenSans-Regular.ttf");

        pieChart.setCenterTextTypeface(Typeface.createFromAsset(context.getAssets(), "OpenSans-Light.ttf"));
        pieChart.setCenterText(generateCenterSpannableText());

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);

        pieChart.setTransparentCircleColor(Color.WHITE);
        pieChart.setTransparentCircleAlpha(110);

        pieChart.setHoleRadius(58f);
        pieChart.setTransparentCircleRadius(61f);

        pieChart.setDrawCenterText(true);

        pieChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        pieChart.setRotationEnabled(true);
        pieChart.setHighlightPerTapEnabled(true);

        // pieChart.setUnit(" €");
        // pieChart.setDrawUnitsInChart(true);

        // add a selection listener
        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

            }

            @Override
            public void onNothingSelected() {

            }
        });

        setData(6, 100);

        pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        return view;
    }
    private SpannableString generateCenterSpannableText(){
        SpannableString s=new SpannableString("消费统计\ndeveloped by 赵峰");
        s.setSpan(new RelativeSizeSpan(1.7f),0,4,0);
        s.setSpan(new StyleSpan(Typeface.NORMAL),4,s.length()-2,0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY),4,s.length()-2,0);
        s.setSpan(new RelativeSizeSpan(.8f),4,s.length()-2,0);
        s.setSpan(new StyleSpan(Typeface.ITALIC),s.length()-2,s.length(),0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()),s.length()-2,s.length(),0);
        return s;
    }
    private void setData(int count,float range){
        float mult=range;
        ArrayList<Entry> yVals1=new ArrayList<>();

        for(int i=0;i<count;i++){
            yVals1.add(new Entry((float)(Math.random()*mult)+mult/5,i));
        }
        ArrayList<String> xVals=new ArrayList<>();
        xVals.add(ConsumeType.Advance.getString(context));
        xVals.add(ConsumeType.Daily.getString(context));
        xVals.add(ConsumeType.Entertainment.getString(context));
        xVals.add(ConsumeType.Food.getString(context));
        xVals.add(ConsumeType.Others.getString(context));
        xVals.add(ConsumeType.Transport.getString(context));
        PieDataSet dataSet=new PieDataSet(yVals1,"");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        //add a lot of colors
        ArrayList<Integer> colors=new ArrayList<>();
        for(int c:ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for(int c:ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for(int c:ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for(int c:ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for(int c:ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);

        PieData data=new PieData(xVals,dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        data.setValueTypeface(tf);
        pieChart.setData(data);
        pieChart.highlightValue(null);
        pieChart.invalidate();
    }
}
