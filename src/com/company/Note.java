package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Note
{
    public final List<String> notes = new ArrayList<String>();
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addNote(int index, String note)
    {
        lock.writeLock().lock();
        System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
        notes.add(index, note);
        System.out.println("Уже добавлена заметка [" + note + "]");
        lock.writeLock().unlock();
    }

    public void removeNote(int index)
    {
        lock.writeLock().lock();
        System.out.println("Сейчас будет удалена заметка с позиции " + index);
        String note;
        note = notes.remove(index);
        System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
        lock.writeLock().unlock();
    }

    public void readNote(int index)
    {
        lock.readLock().lock();
        System.out.println("Сейчас будет прочтена заметка с позиции " + index);
        String note;
        note = notes.get(index);
        System.out.println("Прочтена заметка [" + note + "] с позиции " + index);
        lock.readLock().unlock();
    }

}

