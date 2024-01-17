package Interfaces;

import Characters.Princess;

import java.util.function.Predicate;

public interface MarriagePredicate extends Predicate<Princess> {
   boolean test(Princess princess);
}
