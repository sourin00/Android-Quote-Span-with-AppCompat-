# Android Quote Span with AppCompat Support using both Java and Kotlin
This is the easiest way to implement Android Quote Span with customized Stripe width and Gap width without writing your own Quote Span class while maintaining support for Android API level 27 and below. I am using a Parcel to pass the width parameters to the QuoteSpan object.

## Getting Started

Use this if you want to implement Android Quote Span without implementing your custom Quote Span class and reuse Google readymade one along with customizing the Stripe width and Gap width.

### Prerequisites

No special requirements as it supports all API Levels since version 1.

```
compileSdkVersion 30

I have used the latest SDK Version in my project. You may use any version.

```

### Implementation

Layout code:
A simple TextView will do as most of the work is done dynamically which we will see in the next step.

```
    <TextView
                android:id="@+id/quoteSpan"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_marginTop="5dp"
                android:layout_marginBottom="8dp"
                android:background="#F1F6F6"
                android:fontFamily="serif-monospace"
                android:padding="5dp"
                android:textStyle="bold"
                android:textSize="16sp"
                app:layout_constraintBottom_toTopOf="@+id/LineDate"
                app:layout_constraintEnd_toEndOf="@+id/title1"
                app:layout_constraintStart_toStartOf="@+id/title1"
                app:layout_constraintTop_toBottomOf="@+id/LineThree"
                app:layout_constraintVertical_bias="0.0"
                android:text="@string/top_review" />
    
```

#### Main implementation code for Kotlin developers

```
val parcel = Parcel.obtain()
parcel.writeInt(getColor(R.color.colorAccent)) // quote span stripe color .. adjust this as per your liking
parcel.writeInt(10) // quote span stripe width .. adjust this as per your liking
parcel.writeInt(10) // quote span gap with .. adjust this as per your liking
parcel.setDataPosition(0)
val string = SpannableString(getString(R.string.top_review))
val quoteSpan = QuoteSpan(parcel)
string.setSpan(quoteSpan, 0, string.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
findViewById<TextView>(R.id.quoteSpan).text = string
parcel.recycle() // put the parcel object back in the pool
            
```
#### Main implementation code for Java developers 

```
Parcel parcel = Parcel.obtain();
parcel.writeInt(getColor(R.color.colorAccent)); // quote span stripe color .. adjust this as per your liking
parcel.writeInt(10); // quote span stripe width .. adjust this as per your liking
parcel.writeInt(10); // quote span gap with .. adjust this as per your liking
parcel.setDataPosition(0);
SpannableString string = new SpannableString(getString(R.string.top_review));
QuoteSpan quoteSpan = new QuoteSpan(parcel);
string.setSpan(quoteSpan, 0, string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
((TextView) findViewById(R.id.quoteSpan)).setText(string);
parcel.recycle(); // put the parcel object back in the pool

```
## Reference

[Android Quote Span](https://developer.android.com/reference/android/text/style/QuoteSpan)

## Authors

* **Sourin Ghosh** - [Sourin Ghosh](https://github.com/sourin00)
