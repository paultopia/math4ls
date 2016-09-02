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

- Finally, every area of law will sometimes make use of statistical evidence at trial, presented by expert witnesses. 

You need to know how to work with probabilistic ideas because you won't be able to avoid them in the practice of law.

Unfortunately, many lawyers, and even (especially?) many judges, are extraordinarily ignorant of probability and statistics. (Statistics will be a separate explainer, but of course the two go together.) This is unfortunate, but also provides opportunities for lawyers who aren't actually terrified of a few numbers to serve an important role on litigation teams, and even potentially win some cases over their clueless opponents. 

## But I went to law school because I'm scared of math!

Don't worry. I'm not trying to turn you into a data scientist here. For ordinary day-to-day legal understanding, you don't need any math more advanced than 8th grade algebra. 

# Joint Probabilities 

The joint probability of events/facts X and Y is defined as the probability that both are true at the same time.  If X and Y are independent, that's just the product of the probabilities of each. [MORE DETAILS, CONDITIONAL STUFF MAYBE HAS TO COME FIRST?  OR COME AFTER?]

The notion of joint probability reveals a potential puzzle in the law. Suppose a trial finishes in a case that hinges on two independent factual issues. For example, suppose we have a toxic tort case. Defendant denies that the chemical produced by its plant was in the water supply, but also denies that the chemical could, as a matter of biology, have caused the ill effects plaintiff suffered. Plaintiff needs to prove both of those things in order to win, but the probability of one being true is not affected by the probability of the other being true (whether the chemical is poisonous doesn't affect whether it was in the water supply, and vice versa).

Now suppose a juror, based on the evidence presented by plaintiff, assigns a subjective probability of .7 to the chemical being in the water supply, and also assigns a subjective probability of .7 to the chemical's being poisonous. Should she vote for a verdict for the plaintiff? 

Well, it's not clear.^[*See, e.g.*, Edward K. Cheng, *Reconceptualizing the Burden of Proof*, 122 <span style="font-variant:small-caps;">Yale L. J.</span> 1254 (2013) (calling this the "conjunction paradox" and proposing one possible solution). *See also* Ronald J. Allen & Alex Stein, *Evidence, Probability and the Burden of Proof*, 55 <span style="font-variant:small-caps;">Ariz. L. Rev.</span> 557 (2013) (excellent discussion of related problems and literature on same; claiming that practical adjudication rarely involves making probabilistic calculations).] If the rule is "plaintiff must prove every individual fact at issue by a preponderance of the evidence," then it looks like plaintiff wins: it's more likely than not that the chemical was in the water supply, and it's more likely than not that it's poisonous. On the other hand, if the rule is "plaintiff must prove all the facts at issue by a preponderance of the evidence," then it sounds like we're concerned with the *joint* probability of the two claims, i.e. .7 * .7 = .49. Whoops, that's less than half! Plaintiff loses. 

This provides all kind of opportunities for the skillful lawyer who isn't afraid of math. Suppose you're defense counsel, and plaintiff's experts have testified that the probability of those factual issues is each .7. The moment plaintiff's rests, if you understand probability, you should instantly move for a directed verdict and argue for the judge to apply the all-the-facts rule. You might not win, especially if those scholars who argue that the preponderance of the evidence standard isn't probabilistic are right, but it's a sufficiently compelling argument to be well worth trying. This is also something that you could argue to the jury, or try to get in a jury instruction.
