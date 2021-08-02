# TozmicMob

Hello, my name is Sean Mendez. I am a 4th year engineering student and am always looking to learn about new technologies. Originally I coded this plugin many months ago for personal/server use but I decided to post it here due to requests.  

The plugin is designed to only work with paper spigot 1.6.4 for best optimization and capabilities. 


In this plugin, there is a 5% chance for a naturally spawning polar bear with a custom name tag to spawn in the world. The polar bear spawning is coded to not overload or cause performance drops. I have optimized it very well and set the spawn conditions appropriately. The polar bear also has custom attack pathfinders that are different from the regular built in minecraft capabilities. The polarbear with the custom name will attack one without it. 

There is also a freeze command which denies player movement and all actions such as chat, visibility, interaction, etc. The unfreeze command will remove these effects. 

Additionally, few other features are added to aid server owners/admins. Permissions are included to restrict usage to commands. 

 /tozmicmob:
 - plugin author information
    permission: none 
    
 /turtle:
 - spawns turtle helmet
    permission: tozmicmob.turtle
  
 /freeze:
 - freezes player
    permission: tozmicmob.freeze
    
 /unfreeze:
 - unfreezes player
    permission: tozmicmob.unfreeze
