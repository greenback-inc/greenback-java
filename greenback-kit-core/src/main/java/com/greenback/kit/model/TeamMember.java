package com.greenback.kit.model;

public class TeamMember extends GreenbackObject {

    private String teamId;
    private String userId;
    private TeamMemberRole role;
    private TeamMemberState state;
    private User team;
    private User user;

    public String getTeamId() {
        return teamId;
    }

    public TeamMember setTeamId(String teamId) {
        this.teamId = teamId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public TeamMember setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public TeamMemberRole getRole() {
        return role;
    }

    public TeamMember setRole(TeamMemberRole role) {
        this.role = role;
        return this;
    }

    public TeamMemberState getState() {
        return state;
    }

    public TeamMember setState(TeamMemberState state) {
        this.state = state;
        return this;
    }

    public User getTeam() {
        return team;
    }

    public TeamMember setTeam(User team) {
        this.team = team;
        return this;
    }

    public User getUser() {
        return user;
    }

    public TeamMember setUser(User user) {
        this.user = user;
        return this;
    }

}