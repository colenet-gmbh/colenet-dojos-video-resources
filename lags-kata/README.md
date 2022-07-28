# Lags

**TODO: Add minimum requirements and short snipped on how to execute / test**

## About this Kata

This kata seems simple at first a glance, but wait to explore it before said it's an easy one.

## Problem Description

`ABEAS Corp` is a little company with only one plane. `ABEAS Corp's` customers
ask for this plane to help them sometimes.
They send rent request with start time, travel duration, and a price they will 
pay. You could help `ABEAS Corp` by finding the best request combination to
maximize gain.

## Sample Test Cases

Requests are sorted. Here is a sample file with 4 requests.

**Test Data:**

```
AF514 0 5 10
CO5 3 7 14
AF515 5 9 7
BA01 6 9 8
```

**Table View:**

| Flight | Start Time    | Duration   | Price |
|--------|---------------|------------|-------|
| AF514  | 0             | 5          | 10    |
| CO5    | 3             | 7          | 14    |
| AF515  | 5             | 9          | 7     |
| BA01   | 6             | 9          | 8     |

The best combination here is `AF514` and `BA01` with a gain of `10 + 8 = 18`.

Depending on how you want to turn this Kata, the output could be `18`
