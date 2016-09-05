---
title: Probability for Law Students (Draft 1) 
author: Paul Gowder 
toc: true
toc_depth: 3
date: September 2, 2016 
---

# Why?

The law is shot through with ideas about probability, uncertainty, risk, and chance. Consider the following examples, all from core law school courses, and most from the first year: 

- Warrants and arrests must be supported by "probable cause."

- A civil plaintiff must ordinarily prove her case by a "preponderance" of the evidence, which is usually understood to mean that the elements of her case are more likely than not to be true.

- FRE 401(a) provides that the first element of the test for relevant evidence is that "it has any tendency to make a fact more or less probable than it would be without the evidence."

- Torts cases face the perennial problem of "loss of a chance," when the plaintiff's evidence shows, for example, that absent the defendant's negligence he would have had a 25% chance of surviving, and the defendant reduced that chance.

- [crim deterrence theory]

- [torts BPL]

- Finally, every area of law will sometimes make use of statistical evidence at trial, presented by expert witnesses. 

You need to know how to work with probabilistic ideas because you won't be able to avoid them in the practice of law.

Unfortunately, many lawyers, and even (especially?) many judges, are extraordinarily ignorant of probability and statistics. (Statistics will be a separate explainer, but of course the two go together.) This is unfortunate, but also provides opportunities for lawyers who aren't actually terrified of a few numbers to serve an important role on litigation teams, and even potentially win some cases over their clueless opponents. 

## But I went to law school because I'm scared of math!

Don't worry. I'm not trying to turn you into a data scientist here. For ordinary day-to-day legal understanding, you don't need any math more advanced than 8th grade algebra. 

# What is Probability? 

Probability is the mathematical representation of the likelihood of an event under a given set of circumstances (conditions) in a given period of time. We will say, for example, that the probability of winning the jackpot in the lottery from buying one ticket this week is some (very tiny) number like .00000003.  We also sometimes use probability language to refer to states of affairs---we might say, for example, that given what I know about the number of buses in town and the color of the bus that hit the plaintiff, the probability that the bus that hit the plaintiff belonged to the Acme Bus Company is .75.^[This comes from a very famous thought experiment, described in Charles Nesson, The Evidence or the Event? On Judicial Proof and the Acceptability of Verdicts, 98 Harv. L. Rev. 1357 (1985)]  Usually, you won't need to think too hard about the difference between these two ideas. 

We represent probability as a fraction between 0 and 1, where 0 means no chance that an event will happen, and 1 means that an event will definitely happen. If someone starts talking about a probability higher than 1 or lower than 0, they're either clueless or lying.  Normally, we express probability in decimals like .75 or percentages like 75%.  We can also express them in fractions like 3/4, but it's a little easy to confuse those with *odds* (a different mathematical relationship, derived from probability but much harder to work with, and usually only used by people who run gambling operations in order to confuse their customers and take their money), so I'll be avoiding that here. 

There are two big theoretical interpretations of probability, the frequentist and the Bayesian.  Very broadly speaking, the frequentist interpretation of probability says that we are, as the name suggests, talking about frequencies. To say that you have a .75 chance of winning the lottery, to the frequentist, says that if 100 people like you are in the world, we would expect 75 of them to win the lottery.  Well, no, actually, that's the kind of thinking that will lead you to horrible mistakes.  Actually, the frequentist interpretation would be that if we picked a large number of groups of 100 people just like you, then we would expect that on average 75 people in each of those groups would win the lottery. 

By contrast, the Bayesian interpretation is about subjective beliefs.  On the Bayesian interpretation, when I say that I have a subjective probability of .75 in winning the lottery, what I mean is that if I make a large number of predictions with a .75 probability, I expect them to be true about 75% of the time. That is, a Bayesian probability represents a subjective sense of uncertainty.  

For the most part, you don't need to care about these different interpretations.  Statisticians and philosophers care about them a lot, but the practical implications of the two worldviews won't come up in much that lawyers need to deal with. Importantly, in a bit I'll introduce an idea called *Bayes Rule*, but this is *not* a concept that is limited to people to Bayesians, frequentists recognize it too---it's a basic mathematical fact. 

# Probability math

## A single event



Independence
 Conditional probabilities
Base rates.

Basic calculation, marbles.

# Joint Probabilities 

The joint probability of events/facts X and Y is defined as the probability that both are true at the same time.  If X and Y are independent, that's just the product of the probabilities of each. [MORE DETAILS, CONDITIONAL STUFF MAYBE HAS TO COME FIRST?  OR COME AFTER?]

The notion of joint probability reveals a potential puzzle in the law. Suppose a trial finishes in a case that hinges on two independent factual issues. For example, suppose we have a toxic tort case. Defendant denies that the chemical produced by its plant was in the water supply, but also denies that the chemical could, as a matter of biology, have caused the ill effects plaintiff suffered. Plaintiff needs to prove both of those things in order to win, but the probability of one being true is not affected by the probability of the other being true (whether the chemical is poisonous doesn't affect whether it was in the water supply, and vice versa).

Now suppose a juror, based on the evidence presented by plaintiff, assigns a subjective probability of .7 to the chemical being in the water supply, and also assigns a subjective probability of .7 to the chemical's being poisonous. Should she vote for a verdict for the plaintiff? 

Well, it's not clear.^[*See, e.g.*, Edward K. Cheng, *Reconceptualizing the Burden of Proof*, 122 <span style="font-variant:small-caps;">Yale L. J.</span> 1254 (2013) (calling this the "conjunction paradox" and proposing one possible solution). *See also* Ronald J. Allen & Alex Stein, *Evidence, Probability and the Burden of Proof*, 55 <span style="font-variant:small-caps;">Ariz. L. Rev.</span> 557 (2013) (excellent discussion of related problems and literature on same; claiming that practical adjudication rarely involves making probabilistic calculations).] If the rule is "plaintiff must prove every individual fact at issue by a preponderance of the evidence," then it looks like plaintiff wins: it's more likely than not that the chemical was in the water supply, and it's more likely than not that it's poisonous. On the other hand, if the rule is "plaintiff must prove all the facts at issue by a preponderance of the evidence," then it sounds like we're concerned with the *joint* probability of the two claims, i.e. .7 * .7 = .49. Whoops, that's less than half! Plaintiff loses. 

This provides all kind of opportunities for the skillful lawyer who isn't afraid of math. Suppose you're defense counsel, and plaintiff's experts have testified that the probability of those factual issues is each .7. The moment plaintiff's rests, if you understand probability, you should instantly move for a directed verdict and argue for the judge to apply the all-the-facts rule. You might not win, especially if those scholars who argue that the preponderance of the evidence standard isn't probabilistic are right, but it's a sufficiently compelling argument to be well worth trying. This is also something that you could argue to the jury, or try to get in a jury instruction.

# Conditional Probabilities

One of the most important probability topics to understand, and one that people almost always get wrong---often to dire consequences---is conditional probability. 

Conditional probability is a recognition of the fact that some events are not independent. So we need a way of describing the effect that one event happens on the probability of another. For a ridiculous example, the probability that I'll get a concussion today is pretty low, but the probability that I'll get a concussion *given* that I play for the Hawkeyes and there's a football game today is much higher. If we're trying to make judgments about my likelihood of getting a head injury, it would be pretty stupid to fail to take into account that I'm involved in an activity that primarily involves gigantic people bashing my head.^[Bayesians would say that every probability is conditional on the rest of the information I know in the world. But this is more of a philosophical dispute than a practical one for the level of understanding you need.]

The mathematical notation of probability is: 

$P(B|A)$ 

The vertical line signifies the conditional nature of the relationship, i.e., the probability of B conditional on A (imagine B as the concussion, and A as my being a football player). 

It turns out that there's a simple formula for calculating conditional probabilities. I'll give you the math first, and then we'll talk through it: 

$P(B|A) = \frac{P(A|B)P(B)}{P(A)}$

In words: the probability of event B conditional on event A is the product of the probability of event A conditional on event B and the probability of event B, all divided by the probability of event A. 

Here's a concrete example. Suppose you want to know the probability that I'm a football player, given that I have a concussion. Here's how you'd calculate it: 

$P(Football|Concussion) = \frac{P(Concussion|Football)P(Football)}{P(Concussion)}$

So let's get some numbers up in this exploitative college sport/financial scam. Assume that: 

The probability of my having a concussion, given that I'm a football player, is .5: 

$P(Concussion|Football) = .5$

The probability of my being a football player without knowing anything else about me (the "base rate" of football players in the population, or, to Bayesians, the "prior" that you have in my being a football player) is, blessedly, low, say .01: 

$P(Football) = .01$

The probability of my having a concussion without knowing anything else about me (the base rate of concussions) is also pretty low, let's call that .03: 

$P(Concussion) = .03$

So then we can just plug the numbers into our Bayes' Rule equation and come up with our answer:

$P(Football|Concussion) = \frac{(0.5)(0.01)}{(0.03)} = 0.17$

Conceptually, that equation represents the additional information you get about whether I'm likely to be a football player, as a result of learning that I have a concussion. If you're a Bayesian, we'd say that you now have .17 subjective probability in my being a football player, as opposed to merely .01 before (your "posterior probability" as opposed to your "prior probability"); if you're a frequentist you'd say that you expect about 17% of the people you meet who have concussions to be football players, as opposed to 1% of people in the general population.^[Note: I made these numbers up, of course. But really, football is awful.]

# A Collection of Stupid Mistakes

There are a bunch of really classic errors that people make with probability. Don't make them.

## Ignoring Base Rates

The first mistake is just not getting the whole Bayes thing, like, at all. Consider this classic example.  Suppose there's a medical test for some disease, and let's say that it has a 95% accuracy rate. To be more precise, let's say that 95% of the time it says what it should say, given the state of the world: if a patient has the disease, 95% of the time it returns a positive result; if the patient does not have the disease, 95% of the time it returns a negative result.^[Statistical lingo you might see floating around: a Type I error is a "false positive," i.e., if the machine sees someone without the disease and returns a positive result; a Type II error is a "false negative," i.e., if the machine sees someone with the disease and returns a negative result. For simplicity, we're assuming here that the test has identical Type I and Type II error rates.]

Imagine you're a doctor, and you administer that test to a patient. It reads positive. *Are you justified in concluding that there's a 95% chance they have the disease?*  The answer is "no, not without first taking into account the base rate of disease in the population" but this is an incredibly common mistake; people sometimes make incredibly consequential decisions based on this blunder. 

Let's work through this problem.  We can do it in two ways. Both ways require making an assumption about the base rate of the disease in the population. So let's suppose that 2% of the people in the population have the disease.

Ok, first we'll do it a simple and intuitive way. Suppose we test 1000 people. 20 of them will have the disease. Of those, the machine will correctly identify 19, so it'll return 19 positive results and 1 negative results. 980 of our 1000 people will *not* have the disease, but our 95% accuracy machine will only identify 931 of those correctly: it'll return 931 negative results and 49 positive results. 

So out of our 1000 people, we'll get a total of 68 positive results. Of those results, only 19 of the people will have the disease. That's only about 28% (after some rounding)! So you can only conclude that an individual person has a 28 chance of having the disease, not a 95% chance.

Ok, let's do this a bit more formally using Bayes' Rule. This will require some thinking. We want to know the probability of the patient having the disease, given that s/he tested positive. We know the probability of the patient testing positive, given that s/he has the disease (.95), and we know the base rate probability of the patient having the disease (.02), but we seem to be missing a term in our equation: we don't know the base rate probability of getting a positive result on the test. Or do we?

Well, actually, we can calculate it simply by exhaustively describing the possible disjoint states of the world. Let's imagine a patient. 98% of the time, the patient does not have the disease, and 5% of the time, that patient will get a positive result. 2% of the time, the patient will have the disease, and 95% of the time, that patient will get a positive result. So then we can calculate the base rate of the machine returning positive as: 

$P(Positive) = (.98 * .05) + (.02 * .95) = .068$

Now we can plug this all right into Bayes' Rule: 

$P(Disease|Positive) = \frac{P(Positive|Disease)P(Disease)}{P(Positive)} = \frac{(.95)(.02)}{(.068)} ~ .28$

Unsurprisingly, this is the same result we got before. 

## The Conjunction Fallacy.

Here's another classic probability oopsie: 

> Linda is 31 years old, single, outspoken, and very bright. She majored in philosophy. As a student, she was deeply concerned with issues of discrimination and social justice, and also participated in anti-nuclear demonstrations.
>
> a) Linda is a teacher in elementary school. 
> 
> b) Linda works in a bookstore and takes Yoga classes.
>
> c) Linda is active in the feminist movement. 
> 
> d) Linda is a psychiatric social worker. 
> 
> e) Linda is a member of the League of Women Voters.
> 
> f) Linda is a bank teller.
> 
> g) Linda is an insurance salesperson.
> 
> h) Linda is a bank teller and is active in the feminist movement.

Asked to rank these statements in order of probability, the "great majority" of people said that (h) is more probable than (f).^[Amos Tversky & Daniel Kahneman, *Extensional versus intuitive reasoning: The conjunction fallacy in probability judgment,* 90 Psychological Review 293 (1983). I've slightly modified the example given in this paper to more clearly enumerate the options.]  Here's the problem with that judgment: it's *impossible*.  Remember that probabilities lie on the range 0-1 inclusive, and that the joint probability of two independent events is the product of their individual probabilities. It follows that the *maximum* probability of Linda being active in the feminist movement is 1, in which case P(h) = P(f); in all other possible cases, P(h) < P(f). 

This is called the "conjunction fallacy."  Don't make it.^[Note that there's been a ton of debate on the original study, mainly focused on whether experimental subjects really understood (f) to be talking about P(Bank teller) alone and whether they understood (h) to be asking about the conjunction independent events P(Bank teller) and P(Feminist). There have been lots of replication attempts for this experiment in slightly different forms in order to nail it down. If you're worried about them, go read the literature. For present purposes, I just want you to see the error: joint probabilities of independent events can never be more than the individual probability of the least probable individual event.]

# Don't Trust Your Intuitions

There's a famous puzzle called the "Monty Hall Problem." It goes like this: imagine you're in a game show, and the host invites you to pick from three closed doors. One of the doors holds a fancy new sports car, and the other two hold goats. (Let us suppose, perhaps counterfactually, that you prefer a sports car to a goat.) After you choose, the host opens one of the *other* doors, always to reveal a goat.

So now you've picked a door, and the host shows you a goat behind one of the other doors. Importantly, the host knows what door has the car, and s/he always opens a door you didn't choose, and it's always a goat door. Then the host asks if you want to stick with your original choice, or switch to the remaining closed door. If you want to get the sports car, should you stay or switch?

Back in 1990, Marilyn vos Savant, who apparently occupies the spot in the Guinness World Record book for "highest IQ," published this problem in a magazine, and declared that the correct answer was to always switch. In response, many, many people, including a number of mathematicians, blew their stacks and wrote angry letters telling her how wrong she was.

Here's how you might (incorrectly) reason to conclude that she was wrong. At the start of the game, each door had a .33[3333...] chance of having the sports car behind it. Initially, you picked a door at random, so you have a .33 chance of being right to stick. The remaining door also had a .33 chance of being the one with a sports car behind it. Nothing about what the host did changed those probabilities, so you have an equal chance of getting the sports car whether you stick with your original choice or switch.

By contrast, here's the correct way to reason. The host actually gave you additional information when s/he opened the door. Originally, your choice (call it the A-door) had a .33 chance of being correct, and hence a .66[6666666...] chance of the sports car being in one of the two remaining doors (call them the B-doors). So now the host has ruled out one of the B-doors for you, you still know that there's a .33 chance of the car being behind the A-door and a .66 chance of the car being behind the B-doors... but the number of B-doors has been reduced from 2 to 1! So there's a .66 chance of the car behind behind the one door left. You should switch. (Exercise for the reader: use Bayes' rule to prove this mathematically.)

This is a famously difficult problem, and the vast majority of people initially tend to pick the wrong answer. It tends to break our ordinary intuitions, and as a result serves as an excellent demonstration of the fact that you really can't trust your intuitive judgments when it comes to probability.

In case you still don't believe me (and I understand if you don't), you can go online to see this explanation paired with a computer simulation of switching and sticking strategies at http://paul-gowder.com/montyhall/ ---and even includes a link to a mathematical explanation (but really, try to do that part yourself before following the link).  

Here's another way to think of the problem (with thanks to my friend Corey Yanofsky): 

1. Host never offers you the chance to switch; you win 1/3 of the time.

2. Host offers, you're stubborn and never switch: always produces the same outcome as if the host never gave you a chance to switch. Hence 1/3 of the time.

3. Always switch: wins whenever a stubborn player would lose and loses whenever the stubborn player would win; therefore the switcher wins 2/3 of the time.

Here's still another way to think of the problem: suppose instead of 3 doors, there are 100 doors, and the host opens 98 of them. Does switching seem more plausible now? 
