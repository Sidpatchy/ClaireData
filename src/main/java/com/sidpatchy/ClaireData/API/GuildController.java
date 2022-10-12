package com.sidpatchy.ClaireData.API;

import com.sidpatchy.ClaireData.Model.Guild;
import com.sidpatchy.ClaireData.Service.GuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/guild")
@RestController
public class GuildController {

    private final GuildService guildService;

    @Autowired
    public GuildController(GuildService guildService) {
        this.guildService = guildService;
    }

    @PostMapping
    public void addGuild(@RequestBody Guild guild) {
        guildService.addGuild(guild.getGuildID(), guild);
    }

    @GetMapping
    public List<Guild> getAllGuilds() {
        return guildService.getAllGuilds();
    }

    @GetMapping(path = "{guildID}")
    public Guild getGuildById(@PathVariable("guildID") String guildID) {
        return guildService.getGuildByID(guildID)
                .orElse(null);
    }

    @DeleteMapping(path = "{guildID}")
    public void deleteGuildById(@PathVariable("guildID") String guildID) {
        guildService.deleteGuild(guildID);
    }

    @PutMapping(path = "{guildID}")
    public void updateGuild(@PathVariable("guildID") String guildID, @RequestBody Guild guildToUpdate) {
        guildService.updateGuild(guildID, guildToUpdate);
    }
}
