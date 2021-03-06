//Toph - Be Like Hasib

//Used the "Reader" class for faster input

/* 
This problem simply counts the number of guesses to find the target value, so I basically 
increased the "count" variable everytime the "mid" variable was divided by two. 
*/

//the question is added below the code

import java.io.*;

public class J_final
{
    public static void main(String args[]) throws IOException
    { 
        Reader sc=new Reader();
        long n =sc.nextLong();
        long x=sc.nextLong();
        long count=0;
        long low=1;
        long high = n;
        while (low < high)
        {
          long mid =(low+high)/2;
          count++;
          if (mid<x)
          {
            low=mid+1;
          }
          else
          {
            high=mid;
          }
        }
        
            System.out.println(count); 
    } 
} 
class Reader
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;
 
    public Reader()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
 
    public Reader(String file_name) throws IOException
    {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
 
    public String readLine() throws IOException
    {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1)
        {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }
 
    public int nextInt() throws IOException
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do
        {
            ret = ret * 10 + c - '0';
        }  while ((c = read()) >= '0' && c <= '9');
 
        if (neg)
            return -ret;
        return ret;
    }
 
    public long nextLong() throws IOException
    {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }
 
    public double nextDouble() throws IOException
    {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
 
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
 
        if (c == '.')
        {
            while ((c = read()) >= '0' && c <= '9')
            {
                ret += (c - '0') / (div *= 10);
            }
        }
 
        if (neg)
            return -ret;
        return ret;
    }
 
    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }
 
    private byte read() throws IOException
    {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }
 
    public void close() throws IOException
    {
        if (din == null)
            return;
        din.close();
    }
    
}

   
/* 
Hasib, the famous programmer, uses a little game when he teaches Binary Search to his students. He requests them to guess a number between 1 to 100, and then he asks a few questions to them. After his students answer those questions, Hasib magically shouts the predicted number correctly!

But how does he do it? What are those questions that makes him so sure about the predicted number? Well, here’s an example. Let’s assume that the predicted number is 22. So Hasib and his student will have a conversation similar to this:

Hasib: Is your number greater than 50?

Student: No.

Hasib: Is your number greater than 25?

Student: No.

Hasib: Is your number greater than 13?

Student: Yes.

Hasib: Is your number greater than 19?

Student: Yes.

Hasib: Is your number greater than 22?

Student: No.

Hasib: Is your number greater than 21?

Student: Yes.

Hasib: (shouts) Then the number you’ve guessed must be 22!

Student: :O

Let’s take a closer look at Hasib’s technique. Initially, the number is guessed anywhere from 1 to 100. After the first question, Hasib realizes that the guessed number can not be within 51 to 100. So he eliminates this range. His new range becomes from 1 to 50. After the second question, he further eliminates the range from 26 to 50. Thus, after every question, he crosses out about 50 percent of his current range. Eventually, his range starts and ends at the same position, and he becomes sure of the guessed number.

You now want to write an automated system that would mimic Hasib’s magical way of reading people’s mind! Instead of letting people guess a number from 1 to 100, you let people guess a number from 1 to N. You will have to determine, given N and X, that how many questions your system needs to ask (or Hasib would have asked) in order to guess the number X correctly.

Input
The only line of the input contains two integers N (1 ≤ N ≤ 1018) and X (1 ≤ X ≤ N).

Output
Output an integer, the number of questions Hasib would ask if someone guesses a number X between 1 and N.

Samples
Input	Output
2 1
1
Input	Output
100 22
6
*/
