## RobotlegsUpDownPlugin

Still in design stages.

Looking to have two actions with default keys assigned.

Using the Shift key as well, users can limit the resultant 'Jump-To' to only those items marked.

**[!]** marks items implemented in this checkin

## Limiting Jump To

If the Jump-To list has no entries, I want to show some kind of non-intrusive error.

If the Jump-To list finds 1 item, we jump to that.

If the Jump-To list finds > 1 item, we show a list of jump items.

## Actions and Contexts

### UP

Up is mapped to **Ctrl-Alt-Up** and means "Move up in the tier heirarchy"

It has several "contexts" as defined in org.robotlegs.plugins.upDown.chain

#### Mediator Context

1. Find View (Shift)
    1. Check for __view__ property **[!]**
    1. Use simple regex of class, (WidgetMediator looks for WidgetView and Widget, in that order)
1. Find Injected Views
    1. List any Display Tree Object (Sprite?) marked by [Inject] in this mediator

#### Event context

Finds EventDispatch references in classes and lists those

1. Find EventDispatcher In Mediators
1. Find EventDispatcher In Commands
1. Find EventDispatcher In Actors
1. Find EventDispatcher elsewhere

#### Command Context

1. Find Event
    1. check for __event__ property
1. Find Injected Events
    1. List any events marked with [Inject] in this command

#### Actor Context

1. Find actor reference in Command
1. Find actor reference in Mediator
1. Find actor reference in Views

### DOWN

#### View Context

1. Find Mediator (SHIFT)
    1. Find mediators that have a view property matching this class **[!]**
1. Find DispatchEvent
    1. Find any eventDispatchers and list the event references - this may not be helpful at all in views.
1. Find Actor
	1. Find any Actor References in the View

#### Mediator Context

1. Find DispatchEvent
    1. Find any eventDispatchers and list the event references.
1. Find Actor
	1. Find any Actor References in the Mediator

#### Event Context

1. Find Command (SHIFT)
    1. Find commands that have this event reference in the __event__ property
1. Find EventListener
    1. Find anything that listens for this event

#### Command Context

1. Find Injected Actors (SHIFT)
    1. Find any Actor injected into this command
1. Find DispatchEvent
    1. Find any eventDispatchers and list the event references.

#### Actor Context
1. Find DispatchEvent
    1. Find any eventDispatchers and list the event references.

### Identifying Contexts

Context does not refer to the RL Context class. In fact this plugin does nothing with this class as
it would be way too difficult to track down complex mappings. Instead the plugin uses conventions to identify contexts.

* **View** extends sprite?
* **Mediator** extends/implements ...
* **Event** extends flash.event
* **Command** extends/implements ...
* **Actor** extends/implements ...

## TODO

1. Implement Context Identifiers
1. Implement Strategies for each context
1. Create sample code that tests all of the context behaviours
