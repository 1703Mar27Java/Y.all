package com.revature.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.context.support.*;
import org.springframework.http.*;

import com.revature.beans.*;
import com.revature.dao.*;

@Controller
@RequestMapping("/board")
public class PostController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String welcomePage(Model m) {
		return "index";
	}
	@RequestMapping(value="/modLogin",method=RequestMethod.GET)
	public String modLogin(Model m) {
		return "modlogin";
	}
	@RequestMapping(value="/modLogin", method=RequestMethod.POST)
	public String modLogin(@RequestParam(value="username") String username,
						   @RequestParam(value="password") String password,
						   Model m){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ModDao modDao = (ModDao) ac.getBean("myModDao");
		PostDao postDao = (PostDao) ac.getBean("myDao");
		Moderator mod = modDao.getModByLogin(username, password);
		m.addAttribute("moderator", mod);
		m.addAttribute("listThreads", postDao.loadThread(0));
		m.addAttribute("post", new Post());
		ac.close();
		return "catalog";
	}
	@RequestMapping(value="/modFlags", method=RequestMethod.GET)
	public String flaggedThreads(Model m){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		if(true/*m.containsAttribute("moderator")*/){	//if statement is to stop users from typing url
			PostDao postDao = (PostDao) ac.getBean("myDao");
			m.addAttribute("flaggedPosts", postDao.loadFlags());
		}else{
			ac.close();
			return "catalog";
		}
		ac.close();
		return "modflags";
	}
	

	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public String getThreads(Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		m.addAttribute("listThreads", dao.loadThread(0));
		m.addAttribute("post", new Post());
		ac.close();
		return "catalog";
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String addThread(@RequestParam("name") String name, @RequestParam("subject") String subject,
			@RequestParam("comment") String comment, @RequestParam("file") MultipartFile file, Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		Post p = (Post) ac.getBean("post");
		p.setName(name);
		p.setSubject(subject);
		p.setComment(comment);
		
		if (!file.isEmpty()) {
			try {
				p.setImage(file.getBytes());
				BufferedImage inputImage = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
				BufferedImage thumbnail = resizeImage(inputImage, 150, 150);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write( thumbnail, "jpg", baos );
				baos.flush();
				p.setThumb(baos.toByteArray());
				baos.close();
			} catch (IOException e) {
			}
		}
		
		dao.create(p);
		m.addAttribute("threadId", p.getId());
		m.addAttribute("message", "Post Successful!");
		ac.close();
		return "result";
	}

	@RequestMapping(value = "/thread/0", method = RequestMethod.GET)
	public String getThread(Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		m.addAttribute("listThreads", dao.loadThread(0));
		m.addAttribute("post", new Post());
		ac.close();
		return "catalog";
	}

	@RequestMapping(value = "/thread/{threadId}", method = RequestMethod.GET)
	public String getThread(@PathVariable int threadId, Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		m.addAttribute("op", dao.loadPost(threadId));
		m.addAttribute("post", new Post());
		m.addAttribute("threadId", threadId);
		m.addAttribute("listPosts", dao.loadThread(threadId));
		ac.close();
		return "thread";
	}

	@RequestMapping(value = "/thread/reply", method = RequestMethod.POST)
	public String addPost(@RequestParam("parent") int parent, @RequestParam("name") String name, @RequestParam("subject") String subject,
			@RequestParam("comment") String comment, @RequestParam("file") MultipartFile file, Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		Post p = (Post) ac.getBean("post");
		p.setParent(parent);
		p.setName(name);
		p.setSubject(subject);
		p.setComment(comment);
		
		if (!file.isEmpty()) {
			try {
				p.setImage(file.getBytes());
				BufferedImage inputImage = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
				BufferedImage thumbnail = resizeImage(inputImage, 150, 150);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(thumbnail, "jpg", baos);
				baos.flush();
				p.setImage(file.getBytes());
				p.setThumb(baos.toByteArray());
				baos.close();
			} catch (IOException e) {
			}
		}
		
		dao.create(p);
		m.addAttribute("threadId", p.getParent());
		ac.close();
		return "result";
	}

	@RequestMapping(value = "/thread/flagPost")
	public String flagPost(@RequestParam("postId") int postId, Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		Post p = (Post) ac.getBean("post");
		p = dao.loadPost(postId);
		p.setFlag(1);
		dao.update(p);
		m.addAttribute("threadId", p.getParent());
		ac.close();
		return "result";
	}
	@RequestMapping(value = "/thread/unflagPost")
	public String ignoreFlag(@RequestParam("postId") int postId, Model m) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		Post p = (Post) ac.getBean("post");
		p = dao.loadPost(postId);
		p.setFlag(0);
		dao.update(p);
		m.addAttribute("threadId", p.getParent());
		ac.close();
		return "result";
	}

	@RequestMapping(value = "/thread/{threadId}/delete")
	public String removePost(@PathVariable int threadId) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		Post p = dao.loadPost(threadId);
		dao.delete(p);
		ac.close();
		return "result";
	}

	@RequestMapping(value = "/img/{postId}", method=RequestMethod.GET, produces=MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> ListImage(@PathVariable int postId) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		Post p = dao.loadPost(postId);
		byte[] image = p.getImage();
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		ac.close();
		return new ResponseEntity<byte[]>(image, headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/thmb/{postId}", method=RequestMethod.GET, produces=MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> ListThumb(@PathVariable int postId) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PostDao dao = (PostDao) ac.getBean("myDao");
		Post p = dao.loadPost(postId);
		byte[] image = p.getThumb();
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		ac.close();
		return new ResponseEntity<byte[]>(image, headers, HttpStatus.CREATED);
	}

	public BufferedImage resizeImage(BufferedImage inputImage, int resultWidth, int resultHeight) {
		int originWidth = inputImage.getWidth();
		int originHeight = inputImage.getHeight();

		if (originWidth <= resultWidth && originHeight <= resultHeight) {
			return inputImage;
		}

		Scalr.Mode scaleMode = Scalr.Mode.AUTOMATIC;

		int maxSize = 0;
		if (originHeight > originWidth) {
			scaleMode = Scalr.Mode.FIT_TO_WIDTH;
			maxSize = resultWidth;
		} else if (originWidth >= originHeight) {
			scaleMode = Scalr.Mode.FIT_TO_HEIGHT;
			maxSize = resultHeight;
		}

		BufferedImage outputImage = Scalr.resize(inputImage, Scalr.Method.QUALITY, scaleMode, maxSize);

		if (scaleMode.equals(Scalr.Mode.FIT_TO_WIDTH) && outputImage.getHeight() > resultHeight) {
			outputImage = Scalr.resize(outputImage, Scalr.Method.QUALITY, Scalr.Mode.FIT_TO_HEIGHT, resultHeight);
		} else if (scaleMode.equals(Scalr.Mode.FIT_TO_HEIGHT) && outputImage.getWidth() > resultWidth) {
			outputImage = Scalr.resize(outputImage, Scalr.Method.QUALITY, Scalr.Mode.FIT_TO_WIDTH, resultWidth);
		}

		/*int paddingSize = 0;
		if (outputImage.getWidth() != resultWidth) {
			paddingSize = (resultWidth - outputImage.getWidth()) / 2;
		} else if (outputImage.getHeight() != resultHeight) {
			paddingSize = (resultHeight - outputImage.getHeight()) / 2;
		}

		if (paddingSize > 0) {
			outputImage = Scalr.pad(outputImage, paddingSize);

			int x = 0, y = 0, width = 0, height = 0;
			if (outputImage.getWidth() > resultWidth) {
				x = paddingSize;
				y = 0;
				width = outputImage.getWidth() - (2 * paddingSize);
				height = outputImage.getHeight();
			} else if (outputImage.getHeight() > resultHeight) {
				x = 0;
				y = paddingSize;
				width = outputImage.getWidth();
				height = outputImage.getHeight() - (2 * paddingSize);
			}

			if (width > 0 && height > 0) {
				outputImage = Scalr.crop(outputImage, x, y, width, height);
			}
		}*/

		inputImage.flush();
		outputImage.flush();

		return outputImage;
	}
}