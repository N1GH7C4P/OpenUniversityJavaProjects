/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kimmo
 */
@Service
public class VoteService {
    @Autowired
    VoteRepository voteRepository;
    
    public Vote CreateVote(Joke joke) {
        Long jokeId = joke.getId();
        if (voteRepository.findByJokeId(jokeId) == null) {
            Vote v = new Vote(jokeId, 0, 0);
            voteRepository.save(v);
            return v;
        }
        return null;
    }
    
    public void Vote(Joke joke, String value) {
        Long id = joke.getId();
        Vote vote = this.voteRepository.findByJokeId(id);
        if (vote == null) {
            vote = new Vote(id, 0, 0);
        }
        if ("up".equals(value)) {
            vote.setUpVotes(vote.getUpVotes() + 1);
        } else if ("down".equals(value)) {
            vote.setDownVotes(vote.getDownVotes() + 1);
        }
        voteRepository.save(vote);
    }
}
