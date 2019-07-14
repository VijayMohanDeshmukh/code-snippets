package org.examples.codesnippets.ThreadMxExample;

import java.lang.management.ManagementFactory;
import com.sun.management.ThreadMXBean;

/*
 * Example code to understand getThreadAllocatedBytes()
 * method.
 */
public class ThreadMxExample {
	ThreadMXBean threadMXBean = null;
	public ThreadMxExample() {
		 threadMXBean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
		
        System.out.printf("supported=%s enabled=%s%n",
                threadMXBean.isThreadAllocatedMemorySupported(),
                threadMXBean.isThreadAllocatedMemoryEnabled());
	}
	public void currentThreadExample() {
		/*
		 * 
		 */
		long tid = Thread.currentThread().getId();
		long allocBytesStart = threadMXBean.getThreadAllocatedBytes(tid);
		allocateSomeMemory();
		long allocBytesEnd = threadMXBean.getThreadAllocatedBytes(tid);
		long allocBytes = allocBytesEnd - allocBytesStart;
		System.out.printf("allocated=%s%n", allocBytes);
	}
	
	private void allocateSomeMemory() {
		for (int i = 0; i < 100; i++) {
			byte[] b = new byte[1024];
		}
	}
}
